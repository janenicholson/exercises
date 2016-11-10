import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointsTest {
    @Test
    public void add_one_and_two_equals_tree() {
       Points one = new Points(1);
       Points two = new Points(2);
       assertThat(one.plus(two), is(new Points(3)));
    }
}
