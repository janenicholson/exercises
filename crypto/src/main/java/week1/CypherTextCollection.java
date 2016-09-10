package week1;

import java.util.List;

import com.google.common.collect.Lists;

public class CypherTextCollection {
	private List<CypherText> cypherTexts;
	private final CypherText target;
	public CypherTextCollection(String target) {
		cypherTexts = Lists.newArrayList();
		this.target = new CypherText(target);
	}

	public void addAll(List<String> strings) {
		for (String string : strings)
			cypherTexts.add(new CypherText(string));
	}
}
