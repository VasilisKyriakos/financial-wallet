import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class user {

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


    public String toString() {
        return "User id=" + id + ", Name=" +name+  ", mobile=" + mobile + ", password=" + password + ", balance = " + wallet.bankAccounts.get(0).getBalance();
    }


}
