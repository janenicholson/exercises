package week1;

import com.google.common.io.BaseEncoding;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CypherText {
	private final byte[] content;
	public CypherText(String encodedBytes) {
		content = BaseEncoding.base16().lowerCase().decode(encodedBytes);
	}

	public MessageOnTopOfMessage xor(CypherText other) {
		int length = Math.min(content.length, other.content.length);
		byte[] result = new byte[length];
		for (int index = 0; index < length; index++) {
			result[index] = (byte) (content[index] ^ other.content[index]);
		}
		return new MessageOnTopOfMessage(result);
	}
}
