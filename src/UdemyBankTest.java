import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UdemyBankTest {
    private UdemyBank bank;

    @org.junit.Before
    public void setUp() throws Exception {
        bank = new UdemyBank("Regional Test Bank");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addBranch() {
        assertTrue(bank.addBranch("branch1"));
        assertFalse(bank.addBranch("branch1")); //we only add a branch if it hasn't been added already
    }

    @org.junit.Test
    public void addCustomer() {
        bank.addBranch("branch1");
        assertTrue(bank.addCustomer("branch1", "Mary White", 100.00));
        assertFalse(bank.addCustomer("Non-existant Branch", "Charlie Brown", 200.00));

    }

    @org.junit.Test
    public void addCustomerTransaction() {
        bank.addBranch("branch1");
        bank.addCustomer("branch1", "Mary White", 100.00);
        assertTrue(bank.addCustomerTransaction("branch1", "Mary White", 50.00));
        assertFalse(bank.addCustomerTransaction("branch1", "Snow White", 75.00));

    }

    @org.junit.Test
    public void listCustomersTest() {
        bank.addBranch("branch1");
        bank.addCustomer("branch1", "Mary White", 100.00);
        bank.addCustomer("branch1", "Tim White", 500.00);

        assertTrue(bank.listCustomers("branch1", true));
        assertFalse(bank.listCustomers("branchZ", true));

    }
}