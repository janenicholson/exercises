import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HandTest {
    @Test
    public void empty_hand_has_value_of_zero() {
        Hand hand = new Hand("");
        assertThat(hand.value(), is(Points.zero));
    }

    @Test
    public void hand_with_ace_king_queen_has_value_of_nine() {
        Hand hand = new Hand("AKQ");
        assertThat(hand.value(), is(new Points(9)));
    }
}

