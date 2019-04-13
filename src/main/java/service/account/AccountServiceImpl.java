package service.account;

import configuration.Config;
import model.Account;
import reader.ReadFromFile;
import service.BankTransferService;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AccountServiceImpl {

    static AccountService accountService = new AccountService();

    public List<Account> listUserAccounts(String name) {

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
        accountService.save(account);
    }

    public void transferAmount(BankTransferService bankTransfer){
        accountService.transferAmount(bankTransfer);
    }
}
