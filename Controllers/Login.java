package controllers;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    Scanner myScanner = new Scanner(System.in);

    private ArrayList<User> users;

    public static void main(String[] args) {
        Login login = new Login();
        login.users = InitialiseBank.users();
        login.getDetails();
    }
        // main method and starting point of the programme.

    private void getDetails() {
        System.out.println("Please enter your username:");
        String username = myScanner.nextLine();
        System.out.println("Please enter your password:");
        String password = myScanner.nextLine();
        User user = checkDetails(username, password);
        //using myScanner to get the information that has been entered on then next line in the command line

        if(user != null){
            MainMenu mm = new MainMenu(user);
        }
        else {
            System.out.println("Incorrect username and password, please try again");
            getDetails();
        }
        //if user does not match null then launch main menu - successful log in- else print out error for incorrect login
    }

    private User checkDetails(String username, String password) {

        for(User u : users){
            if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
        //enhanced for loop - creating a new user 'u' in users - cycles the users in arraylist
        //if 'u' users matches entered username and password then details are returned else null is returned.
    }












}
