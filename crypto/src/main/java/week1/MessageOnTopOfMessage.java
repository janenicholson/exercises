package week1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageOnTopOfMessage {
	private final String label;
	private final String message;

	public MessageOnTopOfMessage(String label, byte[] content) {
		this.label = label;
		this.message = new String(tochar(content));
	}

	private char[] tochar(byte[] content) {
		char[] result = new char[content.length];
		int index = 0;
		for (byte x : content)
			result[index++] = charof(x);
		return result;
	}

	private char charof(byte x) {
		if ((x >= 'A'  && x <= 'Z')
			|| (x >= 'a' && x <= 'z'))
			return (char) x;
		return '?';
	}
}
