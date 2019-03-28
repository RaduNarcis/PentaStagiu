package view;

import constant.Constants;
import service.UserLoginService;

import java.util.Scanner;

public class GeneralView implements MyView {

    int option = -1;

    public void displayOptions() {
        System.out.println();
        System.out.println("1. Log in");
        System.out.println("0. Exit");
        option = readOption();
        while (option != Constants.EXIT_OPTION) {
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

    /*
     * preluam datele de la utilizator si incercam sa facem login
     * */
    public boolean processLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter username: ");
        String userName = scanner.nextLine();

        System.out.println("Enter password: ");
        String userPassword = scanner.nextLine();

        return UserLoginService.userLogIn(userName, userPassword);
    }

    public void proceesLogOut(){
        System.out.println("Succesfully logged out!");
        displayOptions();
    }
}
