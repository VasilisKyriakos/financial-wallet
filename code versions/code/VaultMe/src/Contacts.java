import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Contacts {

    public String add = null;
    public  ArrayList<User> contacts = new ArrayList<User>();
    boolean exist = false;


   public boolean showContacts() {

       if((application.loggedInUser.getContacts().contacts).isEmpty())
       {
           System.out.println("!Your Contact List is Empty!");
           return false;
       }
       else {
           System.out.println(application.loggedInUser.getContacts().toString());
           return true;
       }

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
           exist = true;
           break;

       }

       if(exist==false) {
       User l =  User.findUser(add);
       application.loggedInUser.getContacts().contacts.add(l);
       }

   }



    public User retrieveContacts(){

        Scanner input = new Scanner(System.in);
        System.out.println(" \n-- Select Contact:");
        add = input.next();


        while (User.exist(add) == false || add.equals(application.loggedInUser.getName())) {

            System.out.println(" \n-- Select Contact:");
            add = input.next();
        }

        while (!application.loggedInUser.getContacts().contacts.contains(User.findUser(add))) {
            System.out.println(" \n!This user isn't in your contact list!");
            System.out.println(" \n-- Select Contact:");
            add = input.next();
        }

        User find =  User.findUser(add);
        showContacts();
        return find;
    }



    public String retrieveTo(){

        String findUser =  User.findUser(add).toString();
        return findUser;
    }



    public String toString() {

        String out = "*** Contact List ***\n";

        for(User user : contacts){
            //System.out.println(user.getName());
            out = out.concat(user.getName() +"\n");
        }
        return out;
    }

    

}
