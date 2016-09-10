package week1;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CypherTextCollection {
	private List<CypherText> cypherTexts  = Lists.newArrayList();
	private final CypherText target;

	public void addAll(List<CypherText> strings) {
		for (CypherText string : strings)
			cypherTexts.add(string);
	}
}
