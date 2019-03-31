package reader;

import model.Account;
import service.AccountService;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class AccountFileReader {
    private final static Logger logger = Logger.getLogger(AccountFileReader.class.getName());

    private static String USER_ACCOUNT_SEPARATOR = "   ";

    private static AccountFileReader instance = null;

    private AccountFileReader() {
    }

    public static AccountFileReader getInstance() {
        if (instance == null) {
            instance = new AccountFileReader();
        }
        return instance;
    }

    public List<Account> readAccountsFromFile(String path) {
        List<Account> allAccounts = new LinkedList<>();
        File file = new File(AccountService.class.getClassLoader().getResource(path).getFile());

        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {

            String line;
            String[] split;

            while ((line = br.readLine()) != null) {
                split = line.split(USER_ACCOUNT_SEPARATOR);

                if (split.length == 5) {
                    BigDecimal stringDecimal = new BigDecimal(split[3]);
                    double stringDouble = Double.parseDouble(split[4]);
                    Long stringLong = Long.valueOf(split[1]);

                    Account acc = new Account(stringLong, split[1], split[2],stringDecimal, stringDouble, split[4]);
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
