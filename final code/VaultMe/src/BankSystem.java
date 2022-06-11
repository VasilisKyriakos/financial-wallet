
import java.util.ArrayList;
import java.util.Random;


class PaymentInfo
{
    String store;
    float paymentAmount;
}
public class BankSystem {


    static String[] stores = {"Store1", "Store2","Store3","Store4","Store5"};

    static BankAccount Bank = new BankAccount("GR987654321", 1000000);

    public static void validateTransaction(Transaction transfer){

        if (transfer.getFrom().checkBalance(transfer.getAmount())) {
            transfer.setValid(true);
            System.out.println("\nSuccess");


        } else {
            transfer.setValid(false);
            System.out.println("\n!This amount exceeds your balance!");
        }
    }
    public static PaymentInfo createPayment ()
    {
        Random rand = new Random();
        int randomStore = rand.nextInt(1, 5);
        PaymentInfo info = new PaymentInfo();
        info.store = stores[randomStore];
        info.paymentAmount = rand.nextFloat(10,50);
        return info;
    }
}
