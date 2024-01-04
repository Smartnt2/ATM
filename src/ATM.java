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

        System.out.println("Please set your PIN number:");
        int pin = 0;
        try {
            pin = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a number.");
            scan.nextLine();
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

        System.out.println("You are now a customer of Cheese Bank! Welcome!");
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            System.out.println("error");
        }

        int input = 0;
        while(!customer.checkPin(input)) {
            ConsoleUtility.clearScreen();
            System.out.print("Welcome, " + customer.getName() + "Please enter your PIN number: ");
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
            System.out.println("");
        }
    }
}
