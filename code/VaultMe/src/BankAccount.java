import java.lang.String;
import java.util.ArrayList;

public class BankAccount {

    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private String iban;
    private float balance;

    private Transaction transactionObj;

    public Transaction getTransactionObj() {
        return transactionObj;
    }

    public void setTransactionObj(Transaction transactionObj) {
        this.transactionObj = transactionObj;
    }

    public void addBalance(float amount){
        balance += amount;
    }

    public boolean checkBalance(float amount){
        return amount<=balance;
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String _iban) {
        iban = _iban;
    }


    public float getBalance() {
        return balance;
    }

    public void setBalance(float _balance) {
        balance = _balance;
    }

    BankAccount(String _iban , float _balance){
        iban = _iban;
        balance = _balance;
    }



    public String displayTransactions(){

        String out = "*** Transaction List ***\n";
        for(Transaction transaction : transactions){
            out = out.concat("Transaction Id: "+transaction.getId()+ " Type: "+transaction.getType()+"\n");
        }
        return out;
    }






}
