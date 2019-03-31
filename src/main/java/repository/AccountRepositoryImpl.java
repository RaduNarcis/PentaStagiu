package repository;

import constant.Config;
import model.Account;
import reader.AccountFileReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

public class AccountRepositoryImpl {

    private AccountHolder holder = new AccountHolder();
    private AccountFileReader accountFileReader = AccountFileReader.getInstance();
    private final static Logger logger = Logger.getLogger(AccountRepositoryImpl.class.getName());

    public AccountRepositoryImpl() {
        holder.setAllAcount(accountFileReader.readAccountsFromFile(Config.USER_ACCOUNT_FILE));
    }

    public Account find(Long id) {
        return holder.getAccount(id);
    }

    public List<Account> findAll() {
        return holder.getAllAccounts();
    }

    public void save(Account account) {
        account.setId(holder.getNextAccount());
        holder.addAccount(account);
        wrtieToFile(holder.getAllAccounts());
    }

    public void saveAll(List<Account> accounts) {
        for (Account account : accounts) {
            account.setId(holder.getNextAccount());
            holder.addAccount(account);
        }
        wrtieToFile(holder.getAllAccounts());
    }

    private void wrtieToFile(List<Account> accounts) {
        File file = new File(Config.USER_ACCOUNT_FILE);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(String.valueOf(accounts));

        } catch (FileNotFoundException e1) {
            logger.info("Exception!");
        } catch (Exception e2) {
            logger.warning("Exception!");
        }
    }
}
