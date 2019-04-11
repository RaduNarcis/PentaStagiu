package application;

import model.Account;
import model.UserCredentials;

import java.util.List;

public class ApplicationContext {

    public static UserCredentials loggedInUser = null;
    public static List<Account> loggedInUserAccounts = null;

}
