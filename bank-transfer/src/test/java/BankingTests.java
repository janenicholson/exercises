import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankingTests extends Account {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void transfer_amount_from_payer_to_payee() {
        Account payer = new Account();
        Account payee = new Account();
        payer.credit(100);

        payer.transferTo(payee, 50);

        assertEquals(50, payer.getBalance());
        assertEquals(50, payee.getBalance());
    }

}
