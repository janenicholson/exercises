package week1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import lombok.RequiredArgsConstructor;

@Path("/state")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class CypherStateResource {
	private final CypherTextCollection cypherTexts;
	@GET
	@Timed
	public CypherTextCollection report() {
		return cypherTexts;
	}
}
