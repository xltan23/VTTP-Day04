package vttp.d4;

import java.util.UUID;

public class BankAccount {
    private String accName;
    private String accNumber = UUID.randomUUID().toString().substring(0,8);

    public BankAccount(String name) {
        this.accName = name;
    }

    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }
    public String getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    
}