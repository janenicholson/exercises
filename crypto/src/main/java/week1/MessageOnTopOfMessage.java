package week1;

import com.google.common.io.BaseEncoding;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageOnTopOfMessage {
	private final String label;
	private final byte[] content;

	public String toString() {
		return String.format("%s: %s", label, BaseEncoding.base16().lowerCase().encode(content));
	}
}
