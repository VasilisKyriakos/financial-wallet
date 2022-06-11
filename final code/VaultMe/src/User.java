import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;

public class User{



    private int id;
    private String name;
    private String surname;
    private int mobile;
    private String type;

    private eWallet wallet;

    private Contacts contact;


    private String username;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int _id) {
        id = _id;
    }


    public int getMobile() {
        return mobile;
    }

    public void setMobile(int _mobile) {
        mobile = _mobile;
    }



    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    Scanner input = new Scanner(System.in);


    public String getSurname() {
        return surname;
    }

    public void setSurname(String _surname) {
        surname = _surname;
    }



    public String getType() {
        return type;
    }

    public void setType(String _type) {
        type = _type;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String _username) {
        username = _username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        password = _password;
    }



    public eWallet getWallet() {
        return wallet;
    }

    public void setWallet(eWallet _wallet) {
        wallet = _wallet;
    }



    public Contacts getContacts() {
        return contact;
    }

    public void setContacts(Contacts _contact) {
        contact = _contact;
    }



    public static boolean exist(String name)
    {
        for(int i=0; i<application.userList.size(); i++)
        {
            if(name.equals(application.userList.get(i).getName())){
                return true;}
        }
        return false;
    }



    public  int findIndex (String name, ArrayList<User> List)
    {
        for(int i=0; i<List.size(); i++) {

            if(name.equals(List.get(i).getName())) {
                return i;
            }
        }
        return 0;
    }


    public static User findUser (String name)
    {
        for(int i=0; i<application.userList.size(); i++) {

            if(name.equals(application.userList.get(i).getName())) {
                return application.userList.get(i);
            }
        }
        return null;
    }


    public static void showUsers(){
        int temp;
        temp= application.userList.size();

        if(temp==0) {System.out.println("No posts yet");}
        else
        {
            System.out.println("\n****** Users ******");
            for(int i=0; i<application.userList.size(); i++){
                if(application.loggedInUser != application.userList.get(i))
                    System.out.println(application.userList.get(i).name());
            }
        }
    }


    public String toString() {
        return "\n--" +name+ "'s Bank Account\n Balance: " + wallet.bankAccounts.get(0).getBalance();
    }

    public String name() {
        return name;
    }


   public BankAccount chooseBankAccount()
   {
       System.out.println(application.loggedInUser.getWallet().displayWallet());
       System.out.print("Choose an account:");
       int account = input.nextInt();
       while(account < 1 || account > application.loggedInUser.getWallet().bankAccounts.size())
       {
           System.out.println("Please insert a valid option.");
           account = input.nextInt();
       }
       return application.loggedInUser.getWallet().bankAccounts.get(account-1);
   }


}
