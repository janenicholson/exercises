package week1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CypherTextTest {

	private static final String LABEL2 = "message2";
	private static final String LABEL1 = "message1";
	private static final String FROM1AND1 = "message1 xor message1";
	private static final String FROM1AND2 = "message1 xor message2";
	byte[] ZERO = new byte[] {0};
	byte[] FF = new byte[] {-1};

	@Test
	public void zero_hex_xors_ff_to_ff_hex() {
		CypherText cypherText = new CypherText(LABEL1, "00");
		assertThat(cypherText.xor(new CypherText(LABEL2, "ff")), is(new MessageOnTopOfMessage(FROM1AND2, FF)));
	}

	@Test
	public void ff_hex_xors_ff_to_00_hex() {
		CypherText cypherText = new CypherText(LABEL1, "ff");
		assertThat(cypherText.xor(new CypherText(LABEL1, "ff")), is(new MessageOnTopOfMessage(FROM1AND1, ZERO)));
	}

	@Test
	public void extra_length_is_dropped() {
		CypherText cypherText = new CypherText(LABEL1, "ff0a");
		assertThat(cypherText.xor(new CypherText(LABEL2, "ff")), is(new MessageOnTopOfMessage(FROM1AND2, ZERO)));
	}
}
