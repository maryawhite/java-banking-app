import java.util.ArrayList;

public class UdemyBranch {
    //each branch should have an arrayList of customers
    private String name;
    private ArrayList<UdemyCustomer> customers;

    //constructor
    public UdemyBranch(String name) {
        this.name = name;
        this.customers = new ArrayList<UdemyCustomer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<UdemyCustomer> getCustomers() {
        return customers;
    }

    //method to add a new customer
    //(we'll create a new method called findCustomer at the bottom)
    public boolean newCustomer(String customerName, double initialAmount) {
       if(findCustomer(customerName) == null) {
           this.customers.add(new UdemyCustomer(customerName, initialAmount));
           return true;
       }
       return false;
    }

    //add transaction
    public boolean addCustomerTransaction(String customerName, double amount) {
        UdemyCustomer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    //create a findCustomer method. Make it private bc we are using it internally in this class
    private UdemyCustomer findCustomer(String customerName) {
        for(int i = 0; i < this.customers.size(); i++) {
            UdemyCustomer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getCustomerName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

}
