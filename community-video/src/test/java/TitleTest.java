import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.flextrade.jfixture.annotations.Fixture;
import com.flextrade.jfixture.annotations.Range;
import com.flextrade.jfixture.rules.FixtureRule;

@RunWith(MockitoJUnitRunner.class)
public class TitleTest {

    @Rule public FixtureRule jFixtureRule = FixtureRule.initFixtures();

    @Mock EmailAlert emailAlert;
    Title title;

    @Fixture private String name;
    @Fixture private String director;
    @Fixture @Range(min=1920, max=2120) private Integer year;

    @Before
    public void setup() {
        title = new Title(name, director, year);
    }

    @Test
    public void has_copy_for_checkout_when_copy_is_registered() {
        title.registerForCheckout(emailAlert);
        assertThat(title.getCopiesForCheckout(), is(equalTo(1)));
    }

    @Test
    public void tells_email_alert_to_send_alert_to_interested_members() {
        title.registerForCheckout(emailAlert);
        verify(emailAlert).notifyMembers(title);
    }
}
