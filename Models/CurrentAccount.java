package models;

import controllers.FullAccess;
import controllers.LimitedAccess;

public class CurrentAccount extends Account {

    public CurrentAccount(User u){
        accType = "Current";
        if (u.getAge() >= 18) {
            AccBehaviour = new FullAccess();
        }
        else {
            AccBehaviour = new LimitedAccess();
        }
        SetValues();
    }
        //checking if the user information passed in 'u' provides an age of 18 or over, if yes then provide full access class methods
        // if not provide limited access class methods then set the values that are passed from
        // AccountBehavior (limited or full access)

    private void SetValues() {
        AccBehaviour.setValues(this);
    }

}
