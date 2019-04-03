package reader;

import constant.Config;
import model.Account;
import model.UserCredentials;
import service.AccountServiceImpl;
import service.UserLoginServiceImpl;

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
     * read users and passwords
     *
     * @param path
     * @return
     */
    public List<UserCredentials> readUsersFromFile(String path) {
        List<UserCredentials> allUserCredentials = new LinkedList<>();
        File file = new File(UserLoginServiceImpl.class.getClassLoader().getResource(path).getFile());

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
            logger.info("Exception!");
        } catch (Exception e2) {
            logger.warning("Exception!");
        }
        return allUserCredentials;
    }

    public List<Account> readAccountsFromFile(String path) {
        List<Account> allAccounts = new LinkedList<>();
        File file = new File(AccountServiceImpl.class.getClassLoader().getResource(path).getFile());

        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {

            String line;
            String[] split;

            while ((line = br.readLine()) != null) {
                split = line.split(Config.USER_ACCOUNT_SEPARATOR);

                if (split.length == 5) {
                    BigDecimal stringDecimal = new BigDecimal(split[3]);
                    Long stringLong = Long.valueOf(split[1]);

                    Account acc = new Account(stringLong, split[1], split[2], stringDecimal, split[4]);
                    allAccounts.add(acc);
                }
            }
        } catch (FileNotFoundException e1) {
            logger.info("Exception warning!");
        } catch (Exception e2) {
            logger.warning("Exception warning");
        }
        return allAccounts;
    }
}
