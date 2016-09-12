package week1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CypherTextCollection {
	private List<CypherText> cypherTexts  = Lists.newArrayList();
	private final CypherText target;

	public void addAll(List<CypherText> strings) {
		for (CypherText string : strings)
			cypherTexts.add(string);
	}

	public void addAll(CypherText ... strings) {
		for (CypherText string : strings)
			cypherTexts.add(string);
	}

	public List<String> solve(Optional<Integer> index) {
		List<MessageOnTopOfMessage> messages = report(considerCipher(index));
		List<String> strings = messages.stream().map(m->m.getMessage()).collect(Collectors.toList());
		frequencyAnalysis(strings, index);
		return strings;
	}

	private CypherText considerCipher(Optional<Integer> index) {
		return cypherTexts.get(index.orElse(0));
	}

	private void frequencyAnalysis(List<String> strings, Optional<Integer> messageIndex) {
		for (int charIndex = 0; charIndex < considerCipher(messageIndex).getContent().length; charIndex++) {
			int validCount = 0;
			for (String string : strings) {
				if (isValid(getCharacter(charIndex, string))) {
					validCount++;
				}
			}
			if (validCount > 7) {
				guess(messageIndex, charIndex, ' ');
			}
		}
	}

	public void guess(Optional<Integer> messageIndex, int charIndex, char c) {
		setKeyAt(charIndex, considerCipher(messageIndex).guess(charIndex, c));
	}

	private char getCharacter(int charIndex, String string) {
		if (string.length() > charIndex)
			return string.charAt(charIndex);
		return 'x';
	}

	private boolean isValid(char charAt) {
		return charAt != 'x';
	}

	private List<MessageOnTopOfMessage> report(CypherText cypherText) {
		Predicate<CypherText> excludeSelf = new Predicate<CypherText>() {
			@Override
			public boolean test(CypherText t) {
				return !cypherText.getLabel().equals(t.getLabel());
			}
		};
		List<CypherText> cyphers = cypherTexts;
		cyphers.add(target);
		return cyphers.stream()
			.filter(excludeSelf )
			.map(c->c.xor(cypherText))
			.collect(Collectors.toList());
	}

	public void setKeyAt(int i, byte b) {
		for (CypherText cypherText : cypherTexts) {
			cypherText.setKeyAt(i, b);
		}
		target.setKeyAt(i, b);
	}

	public void loadKnowns(List<Known> knowns) {
		for (Known known : knowns) {
			guess(Optional.of(known.getMessageIndex()), known.getCharacterIndex(), known.getCharacter());
		}
	}
}
