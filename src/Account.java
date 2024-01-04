public class Account {
    private String name;
    private String owner;
    private int balance;

    public Account(String name, String owner) {
        this.name = name;
        this.owner = owner;
        balance = 0;
    }

    public void addBalance(int toAdd) {
        balance += toAdd;
    }

    public void subtractBalance(int toSubtract) {
        balance -= toSubtract;
    }
}
