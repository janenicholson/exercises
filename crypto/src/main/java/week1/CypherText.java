package week1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.io.BaseEncoding;

import lombok.Data;

@Data
public class CypherText {
	private final String label;
	private final byte[] content;

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
}
