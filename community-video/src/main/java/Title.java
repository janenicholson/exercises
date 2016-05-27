import lombok.Getter;

public class Title {
    @Getter private int copiesForCheckout = 0;

    public void registerForCheckout(EmailAlert emailAlert) {
        copiesForCheckout++;
        emailAlert.notifyMembers(this);
    }

}
