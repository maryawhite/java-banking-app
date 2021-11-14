# java-banking-app
Simple Banking Application Tutorial from YouTube channel Help People\
https://youtu.be/wQbEH4tVMJA

Create a class named BankAccount. In it, define an int for balance, int for previousTransaction, String for customer name, and String for customer ID.\
include a constructor for name and id\
Create methods for the following:\
deposit\
withdraw\
getPrevious\
showMenu\
Watch the tutorial for how to write the methods.\
showMenu should display a welcome message, and give the following options: Check Balance, Deposit, Withdraw, Previous Transaction, Exit.\
Continue to ask the user what they would like to do until they choose to exit.\

Create a class named BankingApplication:\
in the main method, instantiate a new BankAccount object. and run your program.\

**Bonus**-include a warning message, and/or prevent the user from withdrawing more than they have\
**Bonus**-in the deposit and withdraw methods, add System.out.println stating how much they withdrew or deposited and their new balance.
**Bonus**-change your ints to doubles so the user can enter decimals, and try to incorporate BigDecimal into the code\
**Bonus**-in the switch cases, allow the user to enter upper- or lowercase A,B,C,D,E, remember to update the while condition to use E and e.

**Bonus**-instead of instantiating the new object in your main method, create a method in the BankAccount Class called greetCustomer, and use the user input to instantiate the object with their name. i.e
```
        System.out.println("Hello, enter your name.");
        String customerName = scanner.nextLine();
       
        BankAccount object1 = new BankAccount(customerName, "ID001");
```
**Bonus**-use this code from Baeldung to generate a random alphanumeric ID # for the customer, https://www.baeldung.com/java-random-string
```public void givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();

    System.out.println(generatedString);
}
```
