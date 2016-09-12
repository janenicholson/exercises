package week1;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Known {
	@JsonProperty("message")
	private int messageIndex;
	@JsonProperty("at")
	private int characterIndex;
	@JsonProperty("is")
	private char character;
}
