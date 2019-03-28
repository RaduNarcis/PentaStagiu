package service;

import constant.Config;
import model.Account;
import reader.AccountFileReader;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class AccountService {

    public static Boolean userAccount(String iban, String name, BigDecimal amount, Double balance, String accountType){

        List<Account> allAcounts = AccountFileReader.getInstance().readAccountsFromFile(Config.USER_ACCOUNT_FILE);

        boolean accountExist = false;

        Iterator<Account> accountIterator = allAcounts.iterator();

        while (!accountExist && accountIterator.hasNext()){
            Account acc = accountIterator.next();
            if(acc.getIban().equals(iban) && acc.getAmount().equals(amount) && acc.getName().equals(name) && acc.getBalance().equals(balance) && acc.getAccountType().equals(accountType)) {
                accountExist = true;
            }
        }
        return accountExist;
    }

    public static void showAccount(){

    }
}
