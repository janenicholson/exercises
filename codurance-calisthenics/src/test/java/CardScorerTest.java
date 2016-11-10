import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardScorerTest {
    private CardScorer cardScorer = new CardScorer();
    @Test
    public void ace_card_returns_four_points() {
        Card ace = new Card('A');
        assertThat(cardScorer.score(ace), is(new Points(4)));
    }
    @Test
    public void king_card_is_worth_three_points() {
        Card king = new Card('K');
        assertThat(cardScorer.score(king), is(new Points(3)));
    }
}
