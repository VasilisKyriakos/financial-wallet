import java.lang.String;
import java.lang.*;
import java.io.*;
import java.util.*;

public class application{

    public static void main(String[] args) {

        boolean flag = false;
        boolean exit = false;
        boolean logout = false;
        int j=0;
        int k =0;


        Scanner input = new Scanner(System.in);

        User instance = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setName("Vasilis");
        user2.setName("Thodoris");
        user3.setName("Kyriaki");

        instance.userList.add(user1);
        instance.userList.add(user2);
        instance.userList.add(user3);

        eWallet wallet1 = new eWallet();
        wallet1.bankAccounts.add(new BankAccount("GR1234567", 50.445f));
        user1.setWallet(wallet1);

        eWallet wallet2 = new eWallet();
        wallet2.bankAccounts.add(new BankAccount("GR1234345567", 2000.445f));
        user2.setWallet(wallet2);

        eWallet wallet3 = new eWallet();
        wallet3.bankAccounts.add(new BankAccount("GR123d4345567", 100.445f));
        user3.setWallet(wallet3);


        do {
            while (flag == false) {

                System.out.println("****** Enter username to login ******");
                String username = input.next();
                //System.out.println(instance.userList.size());

                if (User.exist(username, User.userList)) {
                    flag = true;
                    System.out.println("****** Welcome " + username + " *******");
                    j = User.findIndex(username,User.userList);

                } else if (User.exist(username, User.userList) == false)
                    System.out.println("There is no such user.");

            }


            while(logout==false) {

                System.out.println("\n****** Dashboard ******");
                System.out.println(" 1)Transfer\n 2)Payment\n 3)Transactions\n 4)Logout");

                System.out.println("\nGive a choice:");
                int i = input.nextInt();

                switch(i){

                    case 1:

                        User.showUsers();
                        System.out.println(" \n-- Give  User:");
                        String to = input.next();

                        while(User.exist(to,User.userList)==false){
                            System.out.println(" \n-- Give  User:");
                            to = input.next();
                        }

                        k = User.findIndex(to,User.userList);

                        System.out.println(" \n-- Give Transfer Amount:");
                        float amount = input.nextInt();

                        //System.out.println(instance.userList.get(j).getWallet().bankAccounts.get(0).checkBalance(amount));

                        if(User.userList.get(j).getWallet().bankAccounts.get(0).checkBalance(amount))
                        {
                            Transfer transaction = new Transfer(User.userList.get(j).getWallet().bankAccounts.get(0),
                                                                User.userList.get(k).getWallet().bankAccounts.get(0),amount);
                            transaction.executeTransfer();
                        }

                        else {System.out.println("\n!This amount exceeds your balance!");}

                        System.out.println(User.userList.get(j).toString());
                        System.out.println(User.userList.get(k).toString());

                        break;


                    case 4:

                        System.out.println("Do you want to logout?");
                        String reply = input.next();

                        if(reply.equalsIgnoreCase("yes"))
                            logout=true;
                            exit = true;
                        break;
                }
            }

        }while(exit==false);
    }
}

