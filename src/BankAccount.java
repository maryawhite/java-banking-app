import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //constructor
    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    //deposit method
    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //withdraw method
    void withdraw(int amount){
        if(amount != 0){
            if(amount <= balance){
                balance = balance - amount;
                previousTransaction = -amount;  //we are withdrawing, so use the minus symbol...
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
                case 'A':
                    System.out.println("---------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("---------------------------------------");
                    break;
                case 'B':
                    System.out.println("---------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("---------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("---------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("---------------------------------------");
                    int withdrawAmnt = scanner.nextInt();
                    withdraw(withdrawAmnt);
                    break;
                case 'D':
                    System.out.println("---------------------------------------");
                    getPrevious();
                    System.out.println("---------------------------------------");
                    break;
                case 'E':
                    System.out.println("***************************************");
                    break;
                default:
                    System.out.println("Invalid Option. Please enter again.");
                    break;
            }
        }while(option != 'E');
        System.out.println("Thank you for using our service.");
    }
}
