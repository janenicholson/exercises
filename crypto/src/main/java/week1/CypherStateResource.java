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

@Path("/crypto")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class CypherStateResource {
	private final CypherTextCollection cypherTexts;
	@GET
	@Timed
	@Path("/state")
	public List<String> state(@QueryParam("message") Optional<Integer> index) {
		return cypherTexts.solve(index);
	}

	@GET
	@Timed
	@Path("/message")
	public CypherText show(@QueryParam("message") Integer index) {
		return cypherTexts.getCypherTexts().get(index);
	}

	@GET
	@Timed
	@Path("/guessCharacter")
	public CypherText guessCharacter(@QueryParam("message") Integer messageIndex, @QueryParam("at") Integer charIndex, @QueryParam("is") Character c) {
		cypherTexts.guess(Optional.of(messageIndex), charIndex, c);
		return cypherTexts.getCypherTexts().get(messageIndex);
	}

	@GET
	@Timed
	@Path("/guessKey")
	public List<String> guessKey(@QueryParam("at") Integer charIndex, @QueryParam("is") Byte b) {
		cypherTexts.setKeyAt(charIndex, b);
		return state(Optional.empty());
	}
}
