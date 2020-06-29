package models;

public class Account {
// account class that displays account information

    public AccountBehaviour AccBehaviour;

    public double balance;
    public int overDraftLimit;
    public int maxDeposit;
    public int maxWithdrawal;
    public int maxTransfer;
    public String accType;

    public void deposit(){
        AccBehaviour.deposit(this);
    }

    public void withdraw(){
        AccBehaviour.withdraw(this);
    }

    public void transfer(Account acc){
        AccBehaviour.transfer(this, acc);
    }

    public void checkBalance(){
        AccBehaviour.checkBalance(this);
    }
    //references to this account that is passed through the system

}
