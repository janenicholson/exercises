package week1;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	public List<String> state(@QueryParam("messagenumber") Optional<Integer> index) {
		return cypherTexts.solve(index);
	}
}
