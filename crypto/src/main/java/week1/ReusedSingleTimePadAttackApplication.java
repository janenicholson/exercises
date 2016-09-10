package week1;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ReusedSingleTimePadAttackApplication extends Application<ReusedSingleTimePadAttackConfiguration> {
	public static void main(String[] arguments) throws Exception {
		new ReusedSingleTimePadAttackApplication().run(arguments);
	}

	private CypherTextCollection cypherTextCollection;

	@Override
	public void run(ReusedSingleTimePadAttackConfiguration configuration, Environment environment) throws Exception {
		cypherTextCollection = new CypherTextCollection();
		cypherTextCollection.add(configuration.cypherText1);
		cypherTextCollection.add(configuration.cypherText2);
		cypherTextCollection.add(configuration.cypherText3);
		cypherTextCollection.add(configuration.cypherText4);
		cypherTextCollection.add(configuration.cypherText5);
		cypherTextCollection.add(configuration.cypherText6);
		cypherTextCollection.add(configuration.cypherText7);
		cypherTextCollection.add(configuration.cypherText8);
		cypherTextCollection.add(configuration.cypherText9);
		cypherTextCollection.add(configuration.cypherText10);
		cypherTextCollection.add(configuration.targetToDecrypt);
	}
}
