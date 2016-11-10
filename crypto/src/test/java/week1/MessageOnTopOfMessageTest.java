package week1;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MessageOnTopOfMessageTest {

	@Test
	public void tostring_is_calculable() {
		MessageOnTopOfMessage summary = new CypherText("", "2a").xor(new CypherText("", "20"));
		assertThat(summary.toString(), containsString("xor"));
	}

	@Test
	public void replace_non_printable_chars() {
		byte[] bytes = new byte[] {'A', 'Z', 0x00};
		MessageOnTopOfMessage message = new MessageOnTopOfMessage("", bytes);
		assertThat(message.getMessage(), is("AZx "));
	}
}
