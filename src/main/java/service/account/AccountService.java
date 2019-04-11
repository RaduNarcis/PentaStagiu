package service.account;

import configuration.Config;
import model.Account;
import reader.ReadFromFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

public class AccountService {

    private AccountHolder holder = new AccountHolder();

    private ReadFromFile userFileReader = ReadFromFile.getInstance();

    private final static Logger logger = Logger.getLogger(AccountService.class.getName());

    public AccountService() {
        holder.setAllAcounts(userFileReader.readAccountsFromFile(Config.USER_ACCOUNT_FILE));
    }

    public void save(Account account) {
        account.setId(holder.getNextAccountId());
        holder.addAccount(account);
        writeToFile(holder.getAllAccounts());
    }

    private void writeToFile(List<Account> accounts) {
        File file = new File(Config.USER_ACCOUNT_FILE);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Account account : accounts) {
                StringBuffer accountAsString = new StringBuffer();
                accountAsString.append(account.getId());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAccountNumber());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getName());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAmount());
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);
                accountAsString.append(account.getAccountType().value);
                accountAsString.append(Config.USER_ACCOUNT_SEPARATOR);

                bufferedWriter.write(accountAsString.toString());
                bufferedWriter.write(System.lineSeparator());
            }

        } catch (FileNotFoundException e1) {
            logger.warning("Exception!" + e1.getMessage());
        } catch (Exception e2) {
            logger.warning("Exception!" + e2.getMessage());
        }
    }
}
