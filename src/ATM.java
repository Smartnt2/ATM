import com.sun.jdi.connect.Connector;

import java.sql.SQLOutput;
import java.util.*;
public class ATM {
    public ATM() { }

    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Cheese Bank!");
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            System.out.println("error");
        }

        System.out.print("Please enter your name: ");
        String name = scan.nextLine();

        int pin;
        while(true) {
            System.out.print("Please set your PIN number: ");
            try {
                pin = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scan.nextLine();
                try {
                    Thread.sleep(750);
                } catch (InterruptedException i) {
                    System.out.println("error");
                }
                ConsoleUtility.clearScreen();
            }
        }
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        ConsoleUtility.clearScreen();

        Customer customer = new Customer(name, pin);
        Account savings = new Account("Savings Account", name);
        Account checking = new Account("Checking Account", name);
        TransactionHistory transactionHistory = new TransactionHistory();

        System.out.println("You are now a customer of Cheese Bank! Welcome!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("error");
        }

        int input = 0;
        while(!customer.checkPin(input)) {
            ConsoleUtility.clearScreen();
            System.out.print("Please enter your PIN number: ");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scan.nextLine();
                continue;
            }
            if(!customer.checkPin(input)) {
                System.out.println("That is not the correct PIN, please try again.");
            }
        }


        int selection = 0;
        while(selection != 7) {
            System.out.println("Welcome, " + customer.getName() + ", how can we help you today?");
            System.out.println("1. Withdraw money");
            System.out.println("2. Deposit money");
            System.out.println("3. Transfer money between accounts");
            System.out.println("4. Get account balances");
            System.out.println("5. Get transaction history");
            System.out.println("6. Change PIN");
            System.out.println("7. Exit");
            System.out.print("Enter your selection(number 1-7): ");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scan.nextLine();
            }
            if(input == 1) {
                ConsoleUtility.clearScreen();
                int accountSelection;
                while(true) {
                    System.out.println("Would you like to withdraw from 1. Savings or 2. Checking");
                    accountSelection = scan.nextInt();
                    if(accountSelection != 1 && accountSelection != 2) {
                        System.out.println("Please enter either 1 or 2.");
                    } else {
                        break;
                    }
                }
                ConsoleUtility.clearScreen();
                int numFives = 0;
                int numTwenties = 0;
                int withdrawAmount = 0;
                while(withdrawAmount == 0) {
                    System.out.println("This machine only dispenses 5's and 20's.");
                    System.out.print("How many 5's would you like to withdraw?");
                    try {
                        numFives = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                    }
                    System.out.print("How many 20's would you like to withdraw?");
                    try {
                        numTwenties = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                    }
                    withdrawAmount = numFives * 5 + numTwenties * 20;
                }
                if(accountSelection == 1) {
                    if(!savings.subtractBalance(withdrawAmount)) {
                        System.out.println("Insufficient funds.");
                    } else {
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Successfully withdrew " + "$" + withdrawAmount + " from savings");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Current balance in savings account: " + savings.getBalance());
                    }
                } else {
                    if(!checking.subtractBalance(withdrawAmount)) {
                        System.out.println("insufficient funds.");
                    } else {
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Successfully withdrew " + "$" + withdrawAmount + " from checking");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Current balance in checking account: " + checking.getBalance());
                    }
                }

            }

        }
    }
}
