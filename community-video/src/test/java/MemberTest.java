import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {

    private Member member;

    @Before
    public void setUp() throws Exception {
        member = new Member();
    }

    @Test
    public void has_priority_points_after_points_are_awarded() {
        member.awardPoints(10);
        assertThat(member.getPriorityPoints(), is(equalTo(10)));
    }

}
