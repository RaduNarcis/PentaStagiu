package service.account;

import model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountHolder {

    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public void setAllAcounts(List<Account> accounts) {
        for (Account account : accounts) {
            this.accounts.put(account.getId(), account);
        }
    }

    public void setAccount(Account account) {
        this.accounts.put(account.getId(), account);
    }

    public Account getAccount(Long id) {
        return this.accounts.get(id);
    }

    public List<Account> getAllAccountsList() {
        return new ArrayList<Account>(this.accounts.values());
    }

    public Long getNextAccountId() {
        Long nextAccountId = 0L;
        for (Account account : accounts.values()) {
            if (nextAccountId < account.getId()) {
                nextAccountId = account.getId();
            }
        }
        nextAccountId++;
        return nextAccountId;
    }
}
