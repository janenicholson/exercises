import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardScorerTest {
    private CardScorer cardScorer = new CardScorer();
    void compareCardToPoints(char c, int points) {
        Card ace = new Card(c);
        assertThat(cardScorer.score(ace), is(new Points(points)));        
    }
    @Test
    public void ace_card_returns_four_points() {
        compareCardToPoints('A', 4);
    }
    @Test
    public void king_card_is_worth_three_points() {
        compareCardToPoints('K', 3);
    }
    @Test
    public void queen_card_is_worth_two_points() {
        compareCardToPoints('Q',  2);
    }
    
}
