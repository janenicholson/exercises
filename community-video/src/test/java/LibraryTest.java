import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    @Mock private Title title;
    @Mock private Member member;
    @Mock private EmailAlert emailAlert;

    private Library library;

    @Before
    public void setup() {
        library = new Library();
    }

    @Test
    public void have_title_in_library_after_title_is_donated() {
        library.receiveDonation(title, member, emailAlert);
        assertThat(library.getCollection(), hasItem(title));
    }

    @Test
    public void have_title_in_new_titles_list_after_title_is_donated() {
        library.receiveDonation(title, member, emailAlert);
        assertThat(library.getNewTitles(), hasItem(title));
    }

    @Test
    public void tell_title_to_register_for_checkout_when_title_is_donated() {
        library.receiveDonation(title, member, emailAlert);
        verify(title).registerForCheckout(emailAlert);
    }

    @Test
    public void tell_member_to_award_self_points_when_title_is_donated() {
        library.receiveDonation(title, member, emailAlert);
        verify(member).awardPoints(10);
    }
}
