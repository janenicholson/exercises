package week1;

import java.util.List;

import com.google.common.collect.Lists;

public class CypherTextCollection {
	private List<CypherText> cypherTexts;
	private CypherText target = new CypherText("32510ba9babebbbefd001547a810e67149caee11d945cd7fc81a05e9f85aac650e9052ba6a8cd8257bf14d13e6f0a803b54fde9e77472dbff89d71b57bddef121336cb85ccb8f3315f4b52e301d16e9f52f904");
	public CypherTextCollection() {
		cypherTexts = Lists.newArrayList();
	}

	public void add(String string) {
		cypherTexts.add(new CypherText(string));
	}
}
