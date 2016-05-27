import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(exclude="copiesForCheckout")
public class Title {
    private final String name;
    private final String director;
    private final Integer year;

    private int copiesForCheckout = 0;

    public void registerForCheckout(EmailAlert emailAlert) {
        copiesForCheckout++;
        emailAlert.notifyMembers(this);
    }

}
