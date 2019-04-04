package view;

import application.ApplicationContext;
import constant.ViewUtil;
import model.Account;
import model.UserCredentials;
import service.AccountServiceImpl;
import service.UserLoginServiceImpl;

import java.util.List;
import java.util.Scanner;

public class GeneralView implements DisplayView {

    int option = -1;

    public void displayOptions() {
        System.out.println();
        System.out.println("1. Log in");
        System.out.println("0. Exit");
        option = readOption();
        while (option != ViewUtil.EXIT_OPTION) {
            processOption(option);
            displayOptions();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void processOption(int option) {

        switch (option) {
            case 1:
                Boolean loggedIn = processLogin();
                if (loggedIn) {
                    new UserLogInView().displayOptions();
                } else {
                    System.out.println("User, password combination not found");
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * try to log in
     *
     * @return
     */
    public boolean processLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter username: ");
        String userName = scanner.nextLine();

        System.out.println("Enter password: ");
        String userPassword = scanner.nextLine();

        UserCredentials userCredentials = UserLoginServiceImpl.userLogIn(userName, userPassword);

        Boolean userFound = userCredentials != null;
        if (userFound) {
            ApplicationContext.loggedInUser = userCredentials;
            List<Account> accounts = AccountServiceImpl.listUserAccounts(userCredentials.getUserName());
            ApplicationContext.loggedInUserAccounts = accounts;
        }
        return userFound;

        //return UserLoginServiceImpl.userLogIn(userName, userPassword);
    }

    public void proceesLogOut() {
        System.out.println("Succesfully logged out!");
        displayOptions();
    }
}
