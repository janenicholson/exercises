import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HandTest {
    @Test
    public void empty_hand_has_value_of_zero() {
        Hand hand = new Hand();
        assertThat(hand.value(), is(Points.zero));
    }
}
