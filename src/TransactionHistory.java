import java.util.*;
public class TransactionHistory {
    private ArrayList<String> history;
    private int[] transactionNumA;
    private int[] transactionNumS;

    public TransactionHistory() {
        transactionNumA = new int[] {0, 0, 0, 0};
        transactionNumS = new int[] {0, 0, 0, 0};
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

    public void addTransaction(String transactionType) {
        String transaction = transactionType;
        if(transactionType.equals("A")) {
            for(int digit : transactionNumA) {
                transaction += digit;
            }
        } if(transactionType.equals("S")) {
            for(int digit : transactionNumS) {
                transaction += digit;
            }
        }
        history.add(transaction);
    }

    public void getHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }

    public String getLastTransaction() {
        return history.get(history.size()-1);
    }
}
