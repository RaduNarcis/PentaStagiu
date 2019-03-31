package service;

import constant.Config;
import model.Account;
import reader.AccountFileReader;
import repository.AccountRepositoryImpl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class AccountService {

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();

    public static Boolean userAccount(Long id, String iban, String name, BigDecimal amount, Double balance, String accountType) {

        List<Account> allAcounts = AccountFileReader.getInstance().readAccountsFromFile(Config.USER_ACCOUNT_FILE);

        boolean accountExist = false;

        Iterator<Account> accountIterator = allAcounts.iterator();

        while (!accountExist && accountIterator.hasNext()) {
            Account acc = accountIterator.next();
            if (acc.getId().equals(id) && acc.getIban().equals(iban) && acc.getAmount().equals(amount) && acc.getName().equals(name) && acc.getBalance().equals(balance) && acc.getAccountType().equals(accountType)) {
                accountExist = true;
            }
        }
        return accountExist;
    }

    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public List<Account> listAllAcounts(){
        return accountRepository.findAll();
    }
}
