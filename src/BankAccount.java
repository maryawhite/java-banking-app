import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    double balance;
    BigDecimal bdBalance;
    double previousTransaction;
    String customerName;
    String customerId;

    //constructor
    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    //deposit method
    void deposit(double amount){
        if(amount != 0){
            balance = balance + amount;
            BigDecimal bdBalance = BigDecimal.valueOf(balance);
            previousTransaction = amount;
        }
    }

    //withdraw method
    void withdraw(double amount){
        if(amount != 0){
            if(amount <= balance){
                balance = balance - amount;
                BigDecimal bd = BigDecimal.valueOf(balance);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                System.out.println("You withdrew " + amount + ". Your new balance is: " + bd);
                previousTransaction = -amount;     //we are withdrawing, so use the minus symbol...
            } else{
                System.err.println("Warning: Transaction cannot be processed. You do not have that much money in your account.");
            }

        }
    }

    //method to get the previous transaction
    void getPrevious(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    //method to show the menu
    void showMenu(){
        char option = '\0';  //initialize a char with any value
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your id is " + customerId);

        do{
            System.out.println("=========================================");
            System.out.println("Enter an option");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            System.out.println("=========================================");
            option = scanner.next().charAt(0);

            switch(option){
                case 'A', 'a':
                    System.out.println("---------------------------------------");
                    System.out.println("Balance = " + BigDecimal.valueOf(balance).setScale(2, RoundingMode.HALF_UP));  //400.20000000000005
                    System.out.println("---------------------------------------");
                    break;
                case 'B', 'b':
                    System.out.println("---------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("---------------------------------------");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 'C', 'c':
                    System.out.println("---------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("---------------------------------------");
                    double withdrawAmnt = scanner.nextDouble();
                    withdraw(withdrawAmnt);
                    break;
                case 'D', 'd':
                    System.out.println("---------------------------------------");
                    getPrevious();
                    System.out.println("---------------------------------------");
                    break;
                case 'E', 'e':
                    System.out.println("***************************************");
                    break;
                default:
                    System.out.println("Invalid Option. Please enter again.");
                    break;
            }
        }while(option != 'E');
        System.out.println("Thank you for using our service.");
    }

    //method to generate random alphanumeric string from Baeldung
    public static String generatingRandomAlphanumericString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static void greetCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, enter your name.");
        String customerName = scanner.nextLine();
        String cusID = customerName.toUpperCase().charAt(0) + generatingRandomAlphanumericString();
        BankAccount object1 = new BankAccount(customerName, cusID);
        object1.showMenu();
    }

}
