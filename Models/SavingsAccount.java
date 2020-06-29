package models;

import controllers.FullAccess;

public class SavingsAccount extends Account {

    public SavingsAccount(User u){
        accType = "Savings";
            AccBehaviour = new FullAccess();

        SetValues();
    }
    //checking if the user information passed in 'u' provides an age of 18 or over, if yes then provide full access class methods
    // if not provide limited access class methods then set the values that are passed from
    // AccountBehavior (limited or full access)

    private void SetValues() {
        AccBehaviour.setValues(this);
    }
}
