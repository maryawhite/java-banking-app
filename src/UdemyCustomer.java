import java.util.ArrayList;

public class UdemyCustomer {
    //customer class should have an arrayList of Customers
    private String customerName;
    private ArrayList<Double> transactions;

    //constructor
    //in our constructor, we want the customer name, and a 2nd parameter for their initial transaction amnt
    public UdemyCustomer(String customerName, double initialAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    //method to add another transaction
    //we'll also use this in the constructor above
    public void addTransaction(double amount) {
        this.transactions.add(amount);   //add is a built-in method we can use with ArrayList
    }

    //getters
    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

}
