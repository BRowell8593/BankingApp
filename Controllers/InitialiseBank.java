package controllers;

import models.User;

import java.util.ArrayList;

public class InitialiseBank {

    public static ArrayList<User> users(){

        ArrayList<User> users = new ArrayList<User>();
        String[] forenames = {"Ben", "Tom", "Sam", "Scott",};
        String[] surnames = {"Rowell", "Moffit", "Preston", "Bayfield"};
        int[] years = {15, 35, 23, 47};
        //setting up array list with details

        for(int i = 0; i < 4; i++){
            User u = new User();
            u.setId(i + 1);
            u.setForename(forenames[i]);
            u.setSurname(surnames[i]);
            u.setUsername("user" + (i + 1));
            u.setPassword("pass" + (i + 1));
            u.setAge(years[i]);
            users.add(u);
        }
        return users;
    }










}
