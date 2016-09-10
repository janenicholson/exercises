package week1;

import com.codahale.metrics.health.HealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ReusedSingleTimePadAttackApplication extends Application<ReusedSingleTimePadAttackConfiguration> {
	public static void main(String[] arguments) throws Exception {
		new ReusedSingleTimePadAttackApplication().run(arguments);
	}

	@Override
	public void run(ReusedSingleTimePadAttackConfiguration configuration, Environment environment) throws Exception {
		CypherTextCollection cypherTextCollection = new CypherTextCollection(configuration.targetToDecrypt);
		cypherTextCollection.addAll(configuration.cypherTexts);
		environment.jersey().register(new CypherStateResource(cypherTextCollection));
		environment.healthChecks().register("dummy", new HealthCheck() {
			@Override
			protected Result check() throws Exception {
				return Result.healthy();
			}
		});
	}
}
