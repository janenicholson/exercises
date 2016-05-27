import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankingTests extends Account {

    @Test
    public void update_balances_for_payer_and_payee_when_transfer_amount_from_payer_to_payee() {
        Account payer = new Account();
        Account payee = new Account();
        payer.credit(100);

        payer.transferTo(payee, 50);

        assertEquals(50, payer.getBalance());
        assertEquals(50, payee.getBalance());
    }

}
