import java.util.*;
public class TransactionHistory {
    private ArrayList<String> history;

    public TransactionHistory() { }

    public void addTransaction() {}

    public void getHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }
}
