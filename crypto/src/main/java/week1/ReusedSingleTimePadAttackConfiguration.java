package week1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;

@Getter
public class ReusedSingleTimePadAttackConfiguration extends Configuration {
	@JsonProperty
	private List<CypherText> cypherTexts;

	@JsonProperty
	private CypherText targetToDecrypt;

	@JsonProperty
	private DataSourceFactory database;

	@JsonProperty
	private List<Known> knowns;
}
