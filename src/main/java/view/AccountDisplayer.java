package view;

import model.Account;

import java.util.List;

public class AccountDisplayer {

    public void listAccounts(List<Account> accounts){
        for(Account account : accounts){
            System.out.println(account.toString());
        }
    }
}
