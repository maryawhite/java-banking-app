public class UdemyMain {

    public static void main(String[] args) {
        UdemyBank bank = new UdemyBank("Regional USA Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Mary", 50.05);
        bank.addCustomer("Adelaide", "Tim", 175.34);
        bank.addCustomer("Adelaide", "Charlie", 220.12);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.54);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mary", 1.65);

//        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Sydney", true);

        //test invalid data, if the branch doesn't exist
        if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error branch doesn't exist.");
        }

        //if branch already exists
        if(!bank.addBranch("Adelaide")) {
            System.out.println("Error, branch already exists!");
        }

        //if customer doesn't exist at that branch
        if(!bank.addCustomerTransaction("Adelaide", "Layla", 52.55)) {
            System.out.println("Error, customer doesn't exist at that branch!");
        }

        //if customer already exists
        if(!bank.addCustomer("Adelaide", "Tim", 12.21)) {
            System.out.println("Error, customer already exists!");
        }


    }

}
