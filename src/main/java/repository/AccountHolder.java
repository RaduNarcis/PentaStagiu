package repository;

import model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountHolder {

    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public void setAllAcount(List<Account> accounts) {
        for (Account account : accounts) {
            this.accounts.put(account.getId(), account);
        }
    }

    public void addAccount(Account account) {
        this.accounts.put(account.getId(), account);
    }

    public Account getAccount(Long id) {
        return this.accounts.get(id);
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<Account> (this.accounts.values());
        //List<Account> allAccounts = AccountFileReader.getInstance().readAccountsFromFile(Config.USER_ACCOUNT_FILE);
    }

    public Long getNextAccount() {
        Long max = 0L;
        for (Account account : accounts.values()) {
            if (max < account.getId()) {
                max = account.getId();
            }
        }
        return max + 1;
    }
}
