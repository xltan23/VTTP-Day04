package vttp.d4;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BankMap {
    
    public static void main(String[] args) {

        /* 
        BankAccount Ralph = new BankAccount("Ralph");
        BankAccount Terry = new BankAccount("Terry");
        BankAccount Cristiano = new BankAccount("Cristiano");
        BankAccount Ronaldo = new BankAccount("Ronaldo");
        */

        // Creating a list to store the names
        List<String> names = new LinkedList<>();
        names.add("Ralph");
        names.add("Terry");
        names.add("Ronaldo");
        names.add("Cristiano");

        // Define a map <String ID ,Class (to obtain the name)>
        Map<String, BankAccount> accts = new HashMap<>();

        for (String n : names) {
            BankAccount acct = new BankAccount(n);
            accts.put(acct.getAccNumber() , acct);
        }

        // Set contains no duplicate elements (Rightfully so for Key set which are meant to be unique)
        Set<String> keys = accts.keySet();
        // Collection contains duplicate elements 
        Collection<BankAccount> values = accts.values();

        BankAccount acct;
        for (String acctId : keys) {
            acct = accts.get(acctId);
            System.out.printf("AcctId: %s , AcctName: %s\n", acctId , acct.getAccName());
        }


    }
    

    
}
