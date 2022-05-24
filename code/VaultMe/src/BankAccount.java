import java.lang.String;

public class BankAccount {

    private String iban;
    private float balance;

    public void addBalance(float amount){
        balance += amount;
    }

    public boolean checkBalance(float amount){
        return amount>balance;
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

}
