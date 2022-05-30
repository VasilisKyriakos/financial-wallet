import java.util.ArrayList;
import java.lang.String;

public class User{


    public static ArrayList<User> userList = new ArrayList<User>();

    private int id;
    private String name;
    private String surname;
    private int mobile;
    private String type;

    private eWallet wallet;

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




    public static boolean exist(String name, ArrayList<User> List)
    {
        for(int i=0; i<List.size(); i++)
        {
            if(name.equals(List.get(i).getName())){
                return true;}
        }
        return false;
    }



    public static int findIndex (String name, ArrayList<User> List)
    {
        for(int i=0; i<List.size(); i++) {

            if(name.equals(List.get(i).getName())) {
                return i;
            }
        }
        return 0;
    }


    public static void showUsers(){
        int temp;
        temp= userList.size();

        if(temp==0) {System.out.println("No posts yet");}
        else
        {
            System.out.println("\n****** Users ******");
            for(int i=0; i<userList.size(); i++){
                System.out.println( (i+1)+ ". " +userList.get(i).name());
            }
        }
    }

    public String toString() {
        return "\n--" +name+ "'s Bank Account\n Balance: " + wallet.bankAccounts.get(0).getBalance();
    }

    public String name() {
        return name;
    }


}
