import lombok.Getter;

public class Account {

    @Getter
    private int balance;

    public void credit(int amount) {
        balance += amount;
    }

    public void transferTo(Account payee, int amount) {
        credit(-amount);
        payee.credit(amount);
    }

}