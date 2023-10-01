import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UdemyBranchTest {
    private UdemyBank bank;
    private UdemyBranch branch;
    private UdemyCustomer customer;

    @Before
    public void setUp() throws Exception {
        bank = new UdemyBank("Regional Test Bank");
        branch = new UdemyBranch("Test Branch 1");
    }

    @Test
    public void newCustomerTest() {
        assertTrue(branch.newCustomer("Charlie Brown", 300.00));
        assertFalse(branch.newCustomer("Charlie Brown", 300.00)); //can't add the same customer again
    }

    @Test
    public void addCustomerTransactionTest() {
        branch.newCustomer("Mary White", 300.00);
        assertTrue(branch.addCustomerTransaction("Mary White", 50.00));
        assertFalse(branch.addCustomerTransaction("Non Existant", 50.00));
    }
}