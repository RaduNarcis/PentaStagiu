package reader;

import model.Account;
import service.AccountService;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class AccountFileReader {

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
                    BigDecimal bigDecimal = new BigDecimal(split[2]);
                    String stringDecimal = bigDecimal.toString();

                    double myDouble2 = Double.parseDouble(split[3]);
                    Account acc = new Account(split[0], split[1], stringDecimal, myDouble2, split[4]);
                    allAccounts.add(acc);
                }
            }
        } catch (FileNotFoundException e1) {
            // trebuie pus logger
            e1.printStackTrace();
        } catch (Exception e2) {
            // trebuie pus logger
            e2.printStackTrace();
        }
        return allAccounts;
    }
}
