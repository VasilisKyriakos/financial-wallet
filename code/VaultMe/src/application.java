import java.lang.String;

public class application{

    public static void main(String[] args) {

        user user1 = new user();
        user user2 = new user();

        user1.setName("Vasilis");
        user2.setName("Thodoris");


        eWallet wallet1 = new eWallet();
        wallet1.bankAccounts.add(new BankAccount("GR1234567", 50.445f));
        user1.setWallet(wallet1);


        eWallet wallet2 = new eWallet();
        wallet2.bankAccounts.add(new BankAccount("GR1234345567", 2000.445f));
        user2.setWallet(wallet2);

        float amount =  100;

        if(user1.getWallet().bankAccounts.get(0).checkBalance(amount))
        {
            Transfer transaction = new Transfer(user1.getWallet().bankAccounts.get(0),user2.getWallet().bankAccounts.get(0),amount);
            transaction.executeTransfer();
        }
        else {
            System.out.println("Error");

        }

        System.out.println(user1.toString());
        System.out.println(user2.toString());

    }

}
