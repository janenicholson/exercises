package week1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class ReusedSingleTimePadAttackConfiguration extends Configuration {
	@JsonProperty
	List<String> cypherTexts;

	@JsonProperty
	String targetToDecrypt;

	@JsonProperty
	DataSourceFactory database;
}
