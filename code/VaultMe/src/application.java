import java.lang.String;
import java.lang.*;
import java.io.*;
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

        user1.setName("Vasilis");
        user2.setName("Thodoris");
        user3.setName("Kyriaki");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);



        eWallet wallet1 = new eWallet();
        wallet1.bankAccounts.add(new BankAccount("GR1234567", 50.445f));
        user1.setWallet(wallet1);

        eWallet wallet2 = new eWallet();
        wallet2.bankAccounts.add(new BankAccount("GR1234345567", 2000.445f));
        user2.setWallet(wallet2);

        eWallet wallet3 = new eWallet();
        wallet3.bankAccounts.add(new BankAccount("GR123d4345567", 100.445f));
        user3.setWallet(wallet3);


        Contacts contact1 = new Contacts();
        //contact1.contacts.add(user2);
        user1.setContacts(contact1);

        Contacts contact2 = new Contacts();
        //contact2.contacts.add(user1);
        user2.setContacts(contact2);

        Contacts contact3 = new Contacts();
        //contact3.contacts.add(user2);
        user3.setContacts(contact3);


        do {

            System.out.println("*** Type yes if you want to Login ***");
            String ans =input.next();

            if(ans.equals("yes")) {
                logout = false;
                flag=false;

                while (flag == false) {

                    System.out.println("****** Enter username to login ******");
                    String username = input.next();
                    //System.out.println(instance.userList.size());

                    if (User.exist(username)) {
                        flag = true;
                        System.out.println("****** Welcome " + username + " *******");
                        loggedInUser = User.findUser(username);

                    } else if (User.exist(username) == false)
                        System.out.println("There is no such user.");

                }


                while (logout == false) {

                    System.out.println("\n****** Dashboard ******");
                    System.out.println(" 1)Transfer\n 2)Contacts\n 3)Transactions\n 4)Logout");

                    System.out.println("\nGive a choice:");
                    int i = input.nextInt();

                    switch (i) {

                        case 1:

                            User.showUsers();
                            System.out.println(" \n-- Give  User:");
                            String to = input.next();

                            while (User.exist(to) == false) {
                                System.out.println(" \n-- Give  User:");
                                to = input.next();
                            }

                            User k =  User.findUser(to);

                            System.out.println(" \n-- Give Transfer Amount:");
                            float amount = input.nextInt();

                            //System.out.println(instance.userList.get(j).getWallet().bankAccounts.get(0).checkBalance(amount));


                            Transfer transaction = new Transfer(application.loggedInUser.getWallet().bankAccounts.get(0),
                                    k.getWallet().bankAccounts.get(0), amount);

                            BankSystem.validateTransaction(transaction);

                            if(transaction.isValid())
                            {
                                transaction.executeTransfer();
                            }
                            else
                            {
                                System.out.println("\nNot Valid Transaction");
                            }






                            break;


                        case 2:

                            User.showUsers();
                            loggedInUser.getContacts().addContact();

                            break;

                        case 4:

                            System.out.println("Do you want to logout?");
                            String reply = input.next();

                            if (reply.equalsIgnoreCase("yes"))
                            {
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

