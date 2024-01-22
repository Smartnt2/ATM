import java.util.*;
public class TransactionHistory {
    private ArrayList<String> history;
    private int[] transactionNumA;
    private int[] transactionNumS;

    //TransactionNumA and S are int[] for number padding
    //i could probably just use printf but i already made this and i dont want to change it lol
    public TransactionHistory() {
        transactionNumA = new int[] {0, 0, 0, 0};
        transactionNumS = new int[] {0, 0, 0, 0};
        history = new ArrayList<>();
    }

    public void incrementTransactionHistory(String transactionType) {
        if(transactionType.equals("A")) {
            transactionNumA[3]++;
            if (transactionNumA[3] == 10) {
                transactionNumA[3] = 0;
                transactionNumA[2]++;
                if (transactionNumA[2] == 10) {
                    transactionNumA[2] = 0;
                    transactionNumA[1]++;
                    if (transactionNumA[1] == 10) {
                        transactionNumA[1] = 0;
                        transactionNumA[0]++;
                        if (transactionNumA[0] == 10) {
                            transactionNumA = new int[]{0, 0, 0, 0};
                        }
                    }
                }
            }
        } if(transactionType.equals("S")) {
            transactionNumS[3]++;
            if (transactionNumS[3] == 10) {
                transactionNumS[3] = 0;
                transactionNumS[2]++;
                if (transactionNumS[2] == 10) {
                    transactionNumS[2] = 0;
                    transactionNumS[1]++;
                    if (transactionNumS[1] == 10) {
                        transactionNumS[1] = 0;
                        transactionNumS[0]++;
                        if (transactionNumS[0] == 10) {
                            transactionNumS = new int[]{0, 0, 0, 0};
                        }
                    }
                }
            }
        }
    }

   //creates a transaction ID as a string and adds it to the history
    public void addTransaction(String transactionType) {
        StringBuilder transaction = new StringBuilder(transactionType);
        if(transactionType.equals("A")) {
            for(int digit : transactionNumA) {
                transaction.append(digit);
            }
        } if(transactionType.equals("S")) {
            for(int digit : transactionNumS) {
                transaction.append(digit);
            }
        }
        history.add(transaction.toString());
    }

    public void getHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }

    //for use after addTransaction
    public String getLastTransaction() {
        return history.get(history.size()-1);
    }
}
