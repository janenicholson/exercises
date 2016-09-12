package week1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.io.BaseEncoding;

import lombok.Data;

@Data
public class CypherText {
	private final String label;
	private final byte[] content;
	private char[] plainText;

	public CypherText(@JsonProperty("label") String label, @JsonProperty("content") String encodedBytes) {
		this.label = label;
		content = BaseEncoding.base16().lowerCase().decode(encodedBytes);
	}

	public MessageOnTopOfMessage xor(CypherText other) {
		int length = Math.min(content.length, other.content.length);
		byte[] result = new byte[length];
		for (int index = 0; index < length; index++) {
			result[index] = (byte) (content[index] ^ other.content[index]);
		}
		return new MessageOnTopOfMessage(label + " xor " + other.label, result);
	}

	public Stream<MessageOnTopOfMessage> xorWithAll(List<CypherText> cypherTexts) {
		Predicate<CypherText> excludeSelf = new Predicate<CypherText>() {
			@Override
			public boolean test(CypherText t) {
				return !label.equals(t.label);
			}
		};
		return cypherTexts.stream()
				.filter(excludeSelf)
				.map(c->c.xor(this));
	}

	public byte guess(int charIndex, char c) {
		return (byte) (content[charIndex] ^ c);
	}

	public void setPlainTextAt(int charIndex, char c) {
		allocateSecrets();
		plainText[charIndex] = c;
	}

	private void allocateSecrets() {
		if (plainText == null) {
			plainText = new char[content.length];
		}
	}

	public void setKeyAt(int i, byte b) {
		if (content.length > i)
			setPlainTextAt(i, (char)(content[i] ^ b));
	}
}
