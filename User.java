package models;

import java.util.ArrayList;

public class User {

    private int id;
    private String username;
    private String password;
    private String forename;
    private String surname;
    private int age;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    // can only be accessed by the user class due to private. getter and setter allows other classes to access these.
    //getters and setters below all code to be entered without exposing the actual variables to other classes.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts){
        this.accounts = accounts;
    }
}
