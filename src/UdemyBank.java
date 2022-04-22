import java.util.ArrayList;

public class UdemyBank {
    //it should have an arrayList of Branches
    //name
    private String name;
    private ArrayList<UdemyBranch> branches;

    //constructor--also initialize the ArrayList
    public UdemyBank(String name) {
        this.name = name;
        this.branches = new ArrayList<UdemyBranch>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<UdemyBranch> getBranches() {
        return branches;
    }

    //method to add a new branch
    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new UdemyBranch(branchName));
            return true;
        }
        return false;
    }

    //method to add a customer
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        //first check to see if branch exists
        UdemyBranch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false; //we weren't able to store the customer
    }

    //method to add a transaction
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        UdemyBranch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    //private method called findBranch
    private UdemyBranch findBranch(String branchName) {
        for(int i = 0; i < this.branches.size(); i++) {
            UdemyBranch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    //list of customers for that branch and list of their transactions
    public boolean listCustomers(String branchName, boolean showTransactions) {
        UdemyBranch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customers for branch " + branch.getName());
            ArrayList<UdemyCustomer> branchCustomers = branch.getCustomers();
            //the first loop will show all the customers for that branch
            for(int i = 0; i < branchCustomers.size(); i++) {
                UdemyCustomer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getCustomerName() + "[" + (i+1) + "]");
                //the second loop will optionally show transactions
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    //initial transaction amount
    //use autoboxing and unboxing
}
