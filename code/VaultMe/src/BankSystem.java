
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    public static void validateTransaction(Transfer transfer){

        if (transfer.getFrom().checkBalance(transfer.getAmount())) {
            transfer.setValid(true);
            System.out.println("\nSuccess");

        } else {
            transfer.setValid(false);
            System.out.println("\n!This amount exceeds your balance!");
        }


    }

}
