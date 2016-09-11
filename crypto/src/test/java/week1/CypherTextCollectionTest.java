package week1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CypherTextCollectionTest {

	@Mock CypherText target;

	@Test
	public void setting_key_on_cypher_text_alters_keys_on_all_cypher_texts() {
		CypherText cypherText1 = new CypherText(CypherTextTest.LABEL1, "eeff");
		CypherText cypherText2 = new CypherText(CypherTextTest.LABEL2, "ee00");
		CypherTextCollection collection = new CypherTextCollection(target);
		collection.addAll(cypherText1, cypherText2);
		collection.setKeyAt(0, (byte)0xFF);
		collection.setKeyAt(1, (byte)0x11);
		assertThat(cypherText2.getPlainText()[1], is((char)0x11));
	}

}
