package application;

import model.Account;
import model.UserCredentials;

import java.util.List;

/*
 * keeping data of logged in user
 * */
public class ApplicationContext {

    public static UserCredentials loggedInUser = null;
    public static List<Account> loggedInUserAccounts = null;

}
