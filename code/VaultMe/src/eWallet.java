import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class eWallet {
    public ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    boolean exist = false;

    public void addBankAccount() {

        Scanner input = new Scanner(System.in);
        System.out.println(" \n**** Add Bank Account ****");
        System.out.println(" \n-- Insert Iban -- ");
        String add = input.next();

        char first = add.charAt(0);
        char second = add.charAt(1);
        System.out.println(first);
        System.out.println(second);
        
        while(add.length()!=9 && first != 'G' && second != 'R'){
            System.out.println("!Iban must be 9 digits!");
            System.out.println("!The first 2 letters must be GR!");

            System.out.println(" \n-- Insert Iban -- ");
            add = input.next();

            first = add.charAt(0);
            second = add.charAt(1);

        }

        /*while (application.loggedInUser.getWallet().bankAccounts.contains(findIban(add))) {

            System.out.println(" \n!Iban already exists!");
            exist = true;
            break;

        }*/

        //User l =  User.findUser(add);
        if(exist=false){
        Random rand = new Random();
        float randomBalance = rand.nextInt(100, 2000);
        application.loggedInUser.getWallet().bankAccounts.add(new BankAccount(add, randomBalance));
        }

    }


    public String displayWallet(){

        String out = "*** eWallet ***\n";
        for(BankAccount bankAccount : bankAccounts){
            out = out.concat("" +
                    "Iban: "+bankAccount.getIban()+ " Balance: "+bankAccount.getBalance()+"\n");
        }
        return out;
    }


    public float calculateTotalBalance(){

        float balance =0;
        for(BankAccount bankAccount : bankAccounts){
            balance = balance + bankAccount.getBalance();
        }
        return balance;
    }

    public BankAccount findIban (String name)
    {
        for(int i=0; i<bankAccounts.size(); i++) {

            if(name.equals(bankAccounts.get(i).getIban())) {
                return bankAccounts.get(i);
            }
        }
        return null;
    }
}
