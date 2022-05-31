import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class eWallet {
    public ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();


    public void addBankAccount() {

        Scanner input = new Scanner(System.in);
        System.out.println(" \n**** Add Bank Account ****");
        System.out.println(" \n-- Insert Iban -- ");
        String add = input.next();

        /*while (User.exist(add) == false || add.equals(application.loggedInUser.getName())) {

            System.out.println(" \n-- Add Contact:");
            add = input.next();
        }

        while (application.loggedInUser.getContacts().contacts.contains(User.findUser(add))) {

            System.out.println(" \n!Contact already exists!");
            exist = true;
            break;

        }*/

        //User l =  User.findUser(add);
        Random rand = new Random();
        float randomBalance = rand.nextInt(100, 2000);
        application.loggedInUser.getWallet().bankAccounts.add(new BankAccount(add, randomBalance));

    }


    public String displayWallet(){

        String out = "*** Transaction List ***\n";
        for(BankAccount bankAccount : bankAccounts){
            out = out.concat("Transaction Id: "+bankAccount.getIban()+ " Type: "+bankAccount.getBalance()+"\n");
        }
        return out;
    }


}
