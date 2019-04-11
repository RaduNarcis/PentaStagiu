package reader;

import commons.AccountType;
import configuration.Config;
import model.Account;
import model.UserCredentials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ReadFromFile {

    private final static Logger logger = Logger.getLogger(ReadFromFile.class.getName());

    private static ReadFromFile instance = null;

    private ReadFromFile() {
    }

    public static ReadFromFile getInstance() {
        if (instance == null) {
            instance = new ReadFromFile();
        }
        return instance;
    }


    /**
     * Read user and password  from file
     *
     * @param path
     * @return User
     */

    public List<UserCredentials> readUsersFromFile(String path) {
        List<UserCredentials> allUserCredentials = new LinkedList<>();
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(path);

        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {

            String line;
            String[] split;
            while ((line = br.readLine()) != null) {

                split = line.split(Config.USER_ACCOUNT_SEPARATOR);

                if (split.length == 2) {
                    UserCredentials userCredentials = new UserCredentials(split[0], split[1]);
                    allUserCredentials.add(userCredentials);
                }
            }

        } catch (FileNotFoundException e1) {
            logger.warning("This is an warning message!!" + e1.getMessage());
        } catch (Exception e2) {
            logger.warning("This is an warning message!!" + e2.getMessage());
        }
        return allUserCredentials;
    }


    /**
     * Read the accounts list from file
     *
     * @param path
     * @return Acounts
     */
    public List<Account> readAccountsFromFile(String path) {
        List<Account> allAccounts = new LinkedList<>();
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(path);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] split;

            while ((line = br.readLine()) != null) {
                split = line.split(Config.USER_ACCOUNT_SEPARATOR);

                if (split.length == 5) {
                    Long stringLong = Long.valueOf(split[0]);

                    String amountAsString = split[3];
                    if (amountAsString.contains(",")) {
                        amountAsString = amountAsString.replace(",", ".");
                    }
                    BigDecimal amount = new BigDecimal(amountAsString);

                    AccountType accountType = AccountType.valueOf(split[4]);
                    Account acc = new Account(stringLong, split[1], split[2], amount, accountType);
                    allAccounts.add(acc);
                }
            }
        } catch (FileNotFoundException e1) {
            logger.warning("This is an warning message!!" + e1.getMessage());
        } catch (Exception e2) {
            logger.warning("This is an warning message!" + e2.getMessage());
        }
        return allAccounts;
    }
}
