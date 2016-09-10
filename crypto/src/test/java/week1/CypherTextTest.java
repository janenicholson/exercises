package week1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CypherTextTest {

	byte[] ZERO = new byte[] {0};
	byte[] FF = new byte[] {-1};

	@Test
	public void zero_hex_xors_ff_to_ff_hex() {
		CypherText cypherText = new CypherText("00");
		assertThat(cypherText.xor(new CypherText("ff")), is(new MessageOnTopOfMessage(FF)));
	}

	@Test
	public void ff_hex_xors_ff_to_00_hex() {
		CypherText cypherText = new CypherText("ff");
		assertThat(cypherText.xor(new CypherText("ff")), is(new MessageOnTopOfMessage(ZERO)));
	}

	@Test
	public void extra_length_is_dropped() {
		CypherText cypherText = new CypherText("ff0a");
		assertThat(cypherText.xor(new CypherText("ff")), is(new MessageOnTopOfMessage(ZERO)));
	}
}
