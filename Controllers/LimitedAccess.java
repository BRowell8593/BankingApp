package controllers;

import models.Account;
import models.AccountBehaviour;

import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class LimitedAccess extends Account implements AccountBehaviour {

    Scanner myScanner = new Scanner(System.in);

    @Override
    public void withdraw(Account account) {
        System.out.println("How much would you like to withdraw today?");
        int amount = Integer.parseInt(myScanner.nextLine());
        if (amount <= (int) account.balance && (amount <= account.maxWithdrawal)) {
            System.out.println("You have successfully withdrawn £" + amount);
            account.balance = account.balance - amount;
            System.out.println("Your new balance is £" + account.balance);
        }
        else {
            System.out.println("Sorry, you do not have sufficient funds available to complete this transaction or the entered amount is greater than your daily withdrawal limit");
            System.out.println("Would you like to check your current balance? (y/n)");
            String input = myScanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Your current balance is: £" + account.balance);
                System.out.println("Would you like to make a withdrawal? (y/n)");
                String retry = myScanner.nextLine();
                if (retry.equalsIgnoreCase("y")) {
                    withdraw(account);
                }
            }
        } // withdraw method that asks how much the user wishes to withdraw before checking the amount against the balance
        // overdraft and withdraw limit then updating the balance. If there are insufficient funds in the account asks
        // the user if they would like to check their balance before offering the withdraw service again
    }


    @Override
    public void deposit(Account account) {
        System.out.println("Please enter the amount you would wish to deposit: ");
        int deposit = Integer.parseInt(myScanner.nextLine());
        if (deposit <= account.maxDeposit) {
            // update balance
            account.balance = deposit + account.balance;
            System.out.println("You have deposited £" + deposit + " new balance is £" + account.balance + "\n");
        }
        else {
            System.out.println("You cannot deposit more than £500");
            deposit(account);
        }
    }   // Code allowing user to deposit money into accounts, checking that the amount is not over the
        // max deposit limit set in the setValues method.


    @Override
    public void transfer(Account account, Account destination) {
        System.out.println("Please enter how much you would like to transfer.");
        int transfer = Integer.parseInt(myScanner.nextLine());
        if (transfer <= account.maxTransfer && (transfer <= account.balance)) {
            System.out.println("You have transferred £ " + transfer);
            account.balance = account.balance - transfer;
            destination.balance = destination.balance + transfer;
            System.out.println("This accounts balance is now £" + account.balance);
            System.out.println("Your transferred account now has a balance of £" + destination.balance);
        }
        else {
            System.out.println("You cannot transfer more than your transfer limit");
            transfer(account, destination);
        }
    }

    @Override
    public double checkBalance(Account account) {
        System.out.println("Your current balance is £" + account.balance );
        return account.balance;
        // Code checking account balance and showing it to the customer.
    }

    @Override
    public void setValues(Account account) {
        account.maxDeposit = 500;
        account.maxWithdrawal = 300;
        account.maxTransfer = 50;
        account.overDraftLimit = 0;
        //setting the account values for limited access accounts then asking the user if they would like to deposit into
        // their new account
        System.out.println("Would you like to make an initial deposit to your new account? (y/n)");
        String input = myScanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            account.AccBehaviour.deposit(account);
        }
    }
}

