package service;

import constant.Config;
import logic.AccountUtil;
import model.Account;
import reader.ReadFromFile;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AccountServiceImpl {

    AccountUtil accountUtil = new AccountUtil();

    public static List<Account> listUserAccounts(String name) {

        List<Account> allAcounts = ReadFromFile.getInstance().readAccountsFromFile(Config.USER_ACCOUNT_FILE);
        List<Account> userAccounts = new LinkedList<>();

        Iterator<Account> accountIterator = allAcounts.iterator();

        while (accountIterator.hasNext()) {
            Account acc = accountIterator.next();
            if (acc.getName().equals(name)) {
                userAccounts.add(acc);
            }
        }
        return userAccounts;
    }

    public void addAccount(Account account) {
        accountUtil.save(account);
    }

    public List<Account> listAllAcounts() {
        return accountUtil.findAll();
    }


    public boolean processTransfer() {
        accountUtil.saveAll();
        return true;
    }

    public List<Account> transferAmount(String accountNumber, List<Account> accounts, BigDecimal amountToTransfer) {

        for (Account account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                BigDecimal newBalance = amountToTransfer.add(account.getAmount());
                account.setAmount(newBalance);
            }
        }
        return accounts;
    }
}
