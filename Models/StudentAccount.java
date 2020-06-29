package models;

import controllers.LimitedAccess;

public class StudentAccount extends Account {

    public StudentAccount(User u){
        accType = "Student";
        AccBehaviour = new LimitedAccess();

        SetValues();
    }

    private void SetValues() {
        AccBehaviour.setValues(this);
    }

}
