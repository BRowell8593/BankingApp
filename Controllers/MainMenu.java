package controllers;

import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    User user;
    Scanner myScanner = new Scanner(System.in);
    //new instance of scanner

    public MainMenu(User user) {
        this.user = user;
        System.out.println("Welcome Back " + user.getForename());
        getAccount();
    }
    //constructor for MainMenu which requires a user before construction while welcoming the user back to the system

    private void getAccount() {
        if (user.getAccounts().size() > 0) {
            System.out.println("Which account would you like to access?");
            // if the user has an account ask which account they would like to access
            int counter = 1;
            for (Account a : user.getAccounts()) {
                System.out.println(counter + " - " + a.accType);
                counter++;
            }
            // for loop that checks each account in the users array list - creating a dynamic menu. 1) current 2)savings etc
            try {
                String input = myScanner.nextLine();
                //read the next line on command line to receive user input
                Account a = user.getAccounts().get((Integer.parseInt(input)) - 1);
                menu(a);
                //reading the users response from the scanner as the input and removing 1
                // due to array list starting at 0 but menu starting at 1
            } catch (Exception ex) {
                System.out.println("Please enter a valid numerical input");
                getAccount();
                //if invalid repose print error message and re run getAccount method
            }
        } else {
            System.out.println("You do not currently hold an account with us.");
            System.out.println("Would you like to open a new account now? (y/n)");
            String input = myScanner.nextLine();
            //asking the user if they want to create an account using the scanner to read the response as a string
            if (input.equalsIgnoreCase("y")) {
                accountChoice();
                // if user responses y run accountChoice method
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Booooo!");
                System.out.println("Do you wish to continue? (y/n)");
                String cont = myScanner.nextLine();
                // if user response n print line and ask if they want to continue reading response with scanner
                if (cont.equalsIgnoreCase("y")) {
                    getAccount();
                    // if user picks y run getAccount method
                } else if (cont.equalsIgnoreCase("n")) {
                    System.out.println("Very Well, Goodbye");
                    System.exit(0);
                    // if user picks n run LogOut method
                } else {
                    System.out.println("Invalid input provided, continuing...");
                    getAccount();

                }
                // if user provides invalid input to continue question provide error message and run getAccount method
            } else {
                System.out.println("Invalid input provided, please try again");
                getAccount();
                //if user provides invalid input to create an account run error message and getAccount method.
            }
        }
    }

    private void accountChoice() {
        System.out.println("What type of account would you like to open?");
        System.out.println("1 - Personal Current Account");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Student Account");
        String input = myScanner.nextLine();
        //asking the user which account they want to create
        //with a switch method running the create account method for whichever choice is made with an error message to
        //catch exceptions
        switch(input) {
            case "1":
                createAccount("Current");
                break;

            case "2":
                createAccount("Savings");
                break;

            case "3":
                createAccount ("Student");
                break;

            default:
                System.out.println("Invalid option, please try again");
                accountChoice();
        }
    }

    private void createAccount(String type) {
        if(type.equals("Current")){
            CurrentAccount ca = new CurrentAccount(user);
            user.getAccounts().add(ca);
        }
        else if (type.equals("Savings")){
            if( user.getAge() >= 18){
                SavingsAccount sa = new SavingsAccount(user);
                user.getAccounts().add(sa);
            }
            else {
                System.out.println("You must be 18 or older to open a savings account, Sorry");
                accountChoice();
            }//checks if the user is over 18 before allowing them to open a savings account, if not over 18 return them to menu
        }
        else{
            if (user.getAge() < 18) {
                StudentAccount sta = new StudentAccount(user);
                user.getAccounts().add(sta);
            }
            else {
                System.out.println("You must be under 18 to open a student account, Sorry");
                accountChoice();
            } //checks if the user is under 18 and can therefore open a student account, if not sends the user back to the menu
        }
        System.out.println("Congratulations on opening your new account");
        System.out.println("Returning to main menu...");
        getAccount();
    }
    // reading the type selected in the switch statement and calling the required constructor from the required class.
    //for example the current account constructor within the current account class.

    public void menu(Account account) {

        System.out.println("What would you like to do today?");
        System.out.println("1 - Check Account Balance");
        System.out.println("2 - Make a Withdrawal");
        System.out.println("3 - Make a Deposit");
        System.out.println("4 - Make a Transfer");
        System.out.println("5 - Open a New Account");
        System.out.println("6 - Back to Account List");
        System.out.println("7 - Log Out");
        String input = myScanner.nextLine();
        getUserChoice(input, account);
    }

    private void getUserChoice(String input, Account account) {

        switch (input) {
            case "1":
                account.checkBalance();
                break;

            case "2":
                account.withdraw();
                break;

            case "3":
                account.deposit();
                break;

            case "4":
                ArrayList<Account> accounts = user.getAccounts();
                System.out.println("Which account would you like to transfer funds to?");
                Account[] availableAccounts = new Account[10];
                for(Account a : accounts) {
                    if(!a.accType.equals(account.accType)){
                        int counter = 1;
                        System.out.println(counter + " " + a.accType + " Account");
                        availableAccounts[counter - 1] = a;
                    }
                }
                String selection = myScanner.nextLine();
                Account destinationAcc = availableAccounts[Integer.parseInt(selection) - 1];

                account.transfer(destinationAcc);
                break;

            case "5":
                accountChoice();
                break;

            case "6":
                getAccount();
                break;

            case "7":
                System.out.println("Goodbye and have a nice day");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input received, please try again");
                menu(account);
        }
        menu(account);
    }
}           // switch statement displaying menu to the user