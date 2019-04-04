package logic;

import constant.Config;
import model.Account;
import reader.ReadFromFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

public class AccountUtil {

    private AccountHolder holder = new AccountHolder();

    private ReadFromFile userFileReader = ReadFromFile.getInstance();

    private final static Logger logger = Logger.getLogger(AccountUtil.class.getName());

    public AccountUtil() {
        holder.setAllAcount(userFileReader.readAccountsFromFile(Config.USER_ACCOUNT_FILE));
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
        writeToFile(holder.getAllAccounts());
    }

    public void saveAll() {
        writeToFile(holder.getAllAccounts());
    }

    private void writeToFile(List<Account> accounts) {
        File file = new File(Config.USER_ACCOUNT_FILE);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for(Account account : accounts){

                StringBuffer accountAsString = new StringBuffer();
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getId());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAccountNumber());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAmount());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAccountType().value);
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);

                bufferedWriter.write(String.valueOf(accountAsString));
            }

        } catch (FileNotFoundException e1) {
            logger.info("Exception!");
        } catch (Exception e2) {
            logger.warning("Exception!");
        }
    }
}
