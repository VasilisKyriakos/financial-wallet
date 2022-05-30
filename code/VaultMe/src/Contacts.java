import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Contacts {

    public  ArrayList<User> contacts = new ArrayList<User>();


   public void showContacts() {
       System.out.println(application.loggedInUser.getContacts().toString());
   }

   public void addContact(){

       Scanner input = new Scanner(System.in);
       System.out.println(" \n-- Add  Contact:");
       String add = input.next();

       while (User.exist(add) == false || add.equals(application.loggedInUser.getName())) {

           System.out.println(" \n-- Add Contact:");
           add = input.next();
       }

       while (application.loggedInUser.getContacts().contacts.contains(User.findUser(add))) {
           System.out.println(" \n!Contact already exists!");
           System.out.println(" \n-- Add Contact:");
           add = input.next();
       }

       User l =  User.findUser(add);

       application.loggedInUser.getContacts().contacts.add(l);
       showContacts();
   }


    public String toString() {

        String out = "Users\n";

        for(User user : contacts){
            //System.out.println(user.getName());
            out = out.concat(user.getName() +"\n");
        }
        return out;
    }

}
