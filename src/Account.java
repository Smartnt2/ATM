public class Account {
    private String name;
    private String owner;
    private double balance;

    public Account(String name, String owner) {
        this.name = name;
        this.owner = owner;
        balance = 0;
    }

    public void addBalance(double toAdd) {
        balance += toAdd;
    }

    public double getBalance() {
        return balance;
    }

    //false means transaction failed, true means transaction went through
    public boolean subtractBalance(double toSubtract) {
        double temp = balance;
        if(temp - toSubtract < 0) {
            return false;
        } else {
            balance -= toSubtract;
            return true;
        }
    }
}
