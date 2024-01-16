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
        while(input != 7) {
            //ask for pin
            input = 0;
            while(!customer.checkPin(input)) {
                ConsoleUtility.clearScreen();
                System.out.print("Please enter your PIN number: ");
                try {
                    input = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a number.");
                    scan.nextLine();
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e1) {
                        System.out.println("error");
                    }
                    continue;
                }
                if(!customer.checkPin(input)) {
                    System.out.println("That is not the correct PIN, please try again.");
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e1) {
                        System.out.println("error");
                    }
                }
            }
            //menu
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
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e1) {
                    System.out.println("error");
                }
            }
            if(input == 1) {
                //option 1
                ConsoleUtility.clearScreen();
                int accountSelection;
                while(true) {
                    System.out.println("Would you like to withdraw from 1. Savings or 2. Checking");
                    accountSelection = scan.nextInt();
                    if(accountSelection != 1 && accountSelection != 2) {
                        System.out.println("Please enter either 1 or 2.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
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
                    System.out.print("How many 5's would you like to withdraw? ");
                    try {
                        numFives = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                    System.out.print("How many 20's would you like to withdraw? ");
                    try {
                        numTwenties = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                    withdrawAmount = numFives * 5 + numTwenties * 20;
                }
                if(accountSelection == 1) {
                    if(!savings.subtractBalance(withdrawAmount)) {
                        System.out.println("Insufficient funds.");
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    } else {
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Successfully withdrew " + "$" + withdrawAmount + " from savings");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Current balance in savings account: " + savings.getBalance());
                        System.out.println("Press enter to return to the main menu");
                        scan.nextLine();
                    }
                } else {
                    if(!checking.subtractBalance(withdrawAmount)) {
                        System.out.println("insufficient funds.");
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    } else {
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Successfully withdrew " + "$" + withdrawAmount + " from checking");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Current balance in checking account: " + checking.getBalance());
                        System.out.println("Press enter to return to the main menu");
                        scan.nextLine();
                    }
                }

            } if(input == 2) {
                //option 2
                ConsoleUtility.clearScreen();
                int accountSelection;
                while(true) {
                    System.out.println("Would you like to withdraw from 1. Savings or 2. Checking");
                    accountSelection = scan.nextInt();
                    if(accountSelection != 1 && accountSelection != 2) {
                        System.out.println("Please enter either 1 or 2.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    } else {
                        break;
                    }
                }
                ConsoleUtility.clearScreen();
                System.out.print("How much would you like to deposit? ");
                double depositAmount = -1;
                while(depositAmount == -1) {
                    try {
                        depositAmount = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                }
                ConsoleUtility.clearScreen();
                if(accountSelection == 1) {
                    savings.addBalance(depositAmount);
                    transactionHistory.incrementTransactionHistory("A");
                    transactionHistory.addTransaction("A");
                    System.out.println("Successfully deposited " + "$" + depositAmount + " to savings");
                    System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                    System.out.println("Current balance in savings account: " + savings.getBalance());
                    System.out.println("Press enter to return to the main menu");
                    scan.nextLine();
                } else {
                    savings.addBalance(depositAmount);
                    transactionHistory.incrementTransactionHistory("A");
                    transactionHistory.addTransaction("A");
                    System.out.println("Successfully deposited " + "$" + depositAmount + " to checking");
                    System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                    System.out.println("Current balance in checking account: " + checking.getBalance());
                    System.out.println("Press enter to return to the main menu");
                    scan.nextLine();
                }
            } if(input == 3) {
                //option 3
                int fromAccount = 0;
                int toAccount = 0;
                while(fromAccount == 0) {
                    System.out.print("What account do you want to transfer from? 1. Savings or 2. Checking: ");
                    fromAccount = scan.nextInt();
                    if (fromAccount != 1 && fromAccount != 2) {
                        System.out.println("Please enter either 1 or 2.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                }
                while(toAccount == 0) {
                    System.out.print("What account do you want to transfer to? 1. Savings or 2. Checking: ");
                    toAccount = scan.nextInt();
                    if (toAccount != 1 && toAccount != 2) {
                        System.out.println("Please enter either 1 or 2.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                }
                ConsoleUtility.clearScreen();
                double transferAmount = -1;
                System.out.print("How much would you like to transfer? ");
                while(transferAmount == -1) {
                    try {
                        transferAmount = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Please enter a number.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                }
                if(fromAccount == 1) {
                    if(!savings.subtractBalance(transferAmount)) {
                        System.out.println("Insufficient funds in savings account.");
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    } else {
                        checking.addBalance(transferAmount);
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Press enter to return to the main menu");
                        scan.nextLine();

                    }
                } else {
                    if(!checking.subtractBalance(transferAmount)) {
                        System.out.println("Insufficient funds in checking account.");
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    } else {
                        savings.addBalance(transferAmount);
                        transactionHistory.incrementTransactionHistory("A");
                        transactionHistory.addTransaction("A");
                        System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                        System.out.println("Press enter to return to the main menu");
                        scan.nextLine();
                    }
                }
                System.out.println("Transfer successful.");
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e1) {
                    System.out.println("error");
                }
            } if(input == 4) {
                //option 4
                System.out.println("Savings account: " + savings.getBalance());
                System.out.println("Checking account: " + checking.getBalance());
                transactionHistory.incrementTransactionHistory("S");
                transactionHistory.addTransaction("S");
                System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                System.out.println("Press enter to return to the main menu");
                scan.nextLine();
            } if(input == 5) {
                //option 5
                transactionHistory.getHistory();
                transactionHistory.incrementTransactionHistory("S");
                transactionHistory.addTransaction("S");
                System.out.println("Transaction ID: " + transactionHistory.getLastTransaction());
                System.out.println("Press enter to return to the main menu");
                scan.nextLine();
            } if(input == 6) {
                //option 6
                int newPin = -1;
                while(newPin == -1) {
                    System.out.print("Please enter a new PIN number: ");
                    try {
                        newPin = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter an integer.");
                        scan.nextLine();
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e1) {
                            System.out.println("error");
                        }
                    }
                }
                customer.setPin(newPin);
                transactionHistory.incrementTransactionHistory("S");
                transactionHistory.addTransaction("S");
                System.out.println("Changed PIN.");
                System.out.println("Transaction ID" + transactionHistory.getLastTransaction());
                System.out.println("Press enter to return to the main menu");
                scan.nextLine();
            }
        }
    }
}
