
public class Account {

    private int balance;

    public Account() {
        super();
    }

    public void credit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void transferTo(Account payee, int amount) {
        credit(-amount);
        payee.credit(amount);
    }

}