import java.util.ArrayList;

enum HistoryGroups{Outgoing, Ingoing, All};
public class History {

    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();


    public static String showHistory(HistoryGroups type){

        String out = "*** Transaction List ***\n";
        for(Transaction transaction : History.transactions) {
            if (application.loggedInUser.getWallet().bankAccounts.contains(transaction.getFrom()) && (type==HistoryGroups.Outgoing || type==HistoryGroups.All) )
                out = out.concat(" Outgoing Transaction: " + " To: " + transaction.getTo() + " Amount: " + transaction.getAmount() +
                        " Transaction Id: " + transaction.getId() + " Type: " + transaction.getType() + "\n");

            if (application.loggedInUser.getWallet().bankAccounts.contains(transaction.getTo()) && (type==HistoryGroups.Ingoing || type==HistoryGroups.All))
                out = out.concat(" Ingoing Transaction: " + " From: " + transaction.getFrom().toString() +
                        " Amount: " + transaction.getAmount() + " Transaction Id: " + transaction.getId() + " Type: " + transaction.getType() + "\n");

        }
        return out;
    }

}
