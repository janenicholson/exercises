package week1;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MessageOnTopOfMessageTest {

	@Test
	public void tostring_is_calculable() {
		MessageOnTopOfMessage summary = new CypherText("2a").xor(new CypherText("20"));
		assertThat(summary.toString(), instanceOf(String.class));
	}

}
