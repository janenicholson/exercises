package week1;

import java.util.List;
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

	public List<MessageOnTopOfMessage> report() {
		return cypherTexts.stream()
			.flatMap(c->c.xorWithAll(cypherTexts))
			.collect(Collectors.toList());
	}
}
