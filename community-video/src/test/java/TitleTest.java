import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TitleTest {

    @Mock EmailAlert emailAlert;
    Title title;

    @Before
    public void setup() {
        title = new Title();
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
