package week1;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class ReusedSingleTimePadAttackConfiguration extends Configuration {
	String cypherText1;
	@JsonProperty
	String cypherText2;
	@JsonProperty
	String cypherText3;
	@JsonProperty
	String cypherText4;
	@JsonProperty
	String cypherText5;
	@JsonProperty
	String cypherText6;
	@JsonProperty
	String cypherText7;
	@JsonProperty
	String cypherText8;
	@JsonProperty
	String cypherText9;
	@JsonProperty
	String cypherText10;
	@JsonProperty
	String targetToDecrypt;
	@JsonProperty
	DataSourceFactory database;
}
