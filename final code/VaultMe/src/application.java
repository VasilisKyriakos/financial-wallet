import java.lang.String;
import java.lang.*;
import java.util.*;

public class application{

    static User loggedInUser = null;
    static ArrayList<User> userList = new ArrayList<User>();
    public static void main(String[] args) {

        boolean flag = false;
        boolean exit = false;
        boolean logout = false;
        
        Scanner input = new Scanner(System.in);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setName("Vasilis");
        user2.setName("Thodoris");
        user3.setName("Kyriaki");
        user4.setName("Eleni");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        eWallet wallet1 = new eWallet();
        wallet1.bankAccounts.add(new BankAccount("GR1234567", 50.445f));
        user1.setWallet(wallet1);

        eWallet wallet2 = new eWallet();
        wallet2.bankAccounts.add(new BankAccount("GR1234345567", 2000.445f));
        user2.setWallet(wallet2);

        eWallet wallet3 = new eWallet();
        wallet3.bankAccounts.add(new BankAccount("GR123d4345567", 100.445f));
        user3.setWallet(wallet3);

        eWallet wallet4 = new eWallet();
        wallet4.bankAccounts.add(new BankAccount("GR12222345567", 1000000));
        user4.setWallet(wallet4);


        Contacts contact1 = new Contacts();
        user1.setContacts(contact1);

        Contacts contact2 = new Contacts();
        user2.setContacts(contact2);

        Contacts contact3 = new Contacts();
        user3.setContacts(contact3);

        Contacts contact4 = new Contacts();
        user4.setContacts(contact4);

        do {

            System.out.println("*** Type yes if you want to Login ***");
            String ans =input.next();

            if(ans.equals("yes")) {
                logout = false;
                flag=false;

                while (flag == false) {

                    System.out.println("****** Enter username to login ******");
                    String username = input.next();

                    if (User.exist(username)) {
                        flag = true;
                        System.out.println("****** Welcome " + username + " *******");
                        loggedInUser = User.findUser(username);

                    } else if (User.exist(username) == false)
                        System.out.println("There is no such user.");

                }


                while (logout == false) {

                    System.out.println("\n****** Dashboard " +loggedInUser.getName()+ " ******");

                    System.out.println("\n*** Balance ***\n"
                                        +loggedInUser.getWallet().calculateTotalBalance()+
                                            "\n***************\n");

                    System.out.println(" 1)Transfer\n 2)Add Contact\n 3)Transactions\n 4)First-Party Transfer\n " +
                                        "5)Show Contacts\n 6)Add BankAccount\n 7)Show Wallet\n 8)Pay\n 9)Logout");


                    System.out.println("\nGive a choice:");
                    int i = input.nextInt();
                    BankAccount preferredAccount;
                    switch (i) {

                        case 1:

                            if (loggedInUser.getContacts().showContacts()) {

                                preferredAccount = loggedInUser.chooseBankAccount();
                                System.out.println(" \n-- Give Transfer Amount:");
                                float amount = input.nextFloat();

                                Transaction transaction = new Transaction(preferredAccount,
                                        loggedInUser.getContacts().retrieveContacts().getWallet().bankAccounts.get(0), amount, History.transactions.size(), "transfer");

                                BankSystem.validateTransaction(transaction);

                                if (transaction.isValid()) {

                                    transaction.executeTransfer();
                                    History.transactions.add(transaction);
                                    System.out.println(loggedInUser.toString());
                                    System.out.println(loggedInUser.getContacts().retrieveTo());

                                } else {
                                    System.out.println("\nNot Valid Transaction");
                                }

                                break;
                            } else break;


                        case 2:

                            User.showUsers();
                            loggedInUser.getContacts().addContact();
                            break;

                        case 3:

                            System.out.println("Select Type \n 1. Outgoing \n 2. Ingoing \n 3. All \n");
                            int j = input.nextInt();

                            switch (j) {

                                case 1 -> System.out.println(History.showHistory(HistoryGroups.Outgoing));
                                case 2 -> System.out.println(History.showHistory(HistoryGroups.Ingoing));
                                case 3 -> System.out.println(History.showHistory(HistoryGroups.All));
                            }

                            break;

                        case 4:
                            if(loggedInUser.getWallet().bankAccounts.size() > 1)
                            {
                                System.out.println("Please choose a Depositor Account");
                                BankAccount depositorAccount = loggedInUser.chooseBankAccount();
                                System.out.println("Please choose a Beneficiary Account");
                                BankAccount beneficiaryAccount = loggedInUser.chooseBankAccount();

                                while(depositorAccount.getIban().equals(beneficiaryAccount.getIban())) {

                                    System.out.println("Please choose a Depositor Account");
                                    depositorAccount = loggedInUser.chooseBankAccount();
                                    System.out.println("Please choose a Beneficiary Account");
                                    beneficiaryAccount = loggedInUser.chooseBankAccount();

                                }

                                System.out.println(" \n-- Give Transfer Amount:");
                                float amount = input.nextInt();

                                Transaction transaction = new Transaction(depositorAccount,
                                        beneficiaryAccount, amount, History.transactions.size() , "first-party transfer" );

                                BankSystem.validateTransaction(transaction);

                                if (transaction.isValid()) {

                                    transaction.executeTransfer();
                                    History.transactions.add(transaction);
                                    System.out.println(
                                            ". Iban: "+depositorAccount.getIban()+ " Balance: "+ depositorAccount.getBalance()+"\n" +
                                                    ". Iban: "+beneficiaryAccount.getIban()+ " Balance: "+ beneficiaryAccount.getBalance()+"\n");
                                }
                                else {
                                    System.out.println("\nNot Valid Transaction");
                                }
                            }
                            else {
                                System.out.println("You need more than one bank account.");
                            }

                            break;


                        case 5:

                            loggedInUser.getContacts().showContacts();
                            break;

                        case 6:

                            loggedInUser.getWallet().addBankAccount();
                            break;

                        case 7:

                            System.out.println(loggedInUser.getWallet().displayWallet());
                            break;

                        case 8:

                            preferredAccount = loggedInUser.chooseBankAccount();
                            PaymentInfo info = BankSystem.createPayment();
                            System.out.println(loggedInUser.toString());
                            System.out.println("Please confirm your Payment of " + info.paymentAmount + " at " + info.store);
                            ans = input.next();

                            if (ans.equals("yes")) {

                                Transaction transaction = new Transaction(preferredAccount,
                                        BankSystem.Bank, info.paymentAmount, History.transactions.size(), "payment");

                                BankSystem.validateTransaction(transaction);

                                if (transaction.isValid()) {

                                    transaction.executeTransfer();
                                    History.transactions.add(transaction);

                                } else {
                                    System.out.println("\nNot Valid Transaction");
                                }
                            } else {
                                System.out.println("The payment is canceled.");
                            }

                            break;


                        case 9:

                            System.out.println("Do you want to logout?");
                            String reply = input.next();

                            if (reply.equalsIgnoreCase("yes")) {
                                logout = true;
                                loggedInUser = null;
                            }

                            break;

                    }

                }

            }else exit=true;

        }while(exit=true);

    }

}

