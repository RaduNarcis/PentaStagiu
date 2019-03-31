package view;

import constant.Constants;

import java.util.Scanner;

public class UserLogInView implements DisplayView {

    int option = -1;
    AccountView accountView = new AccountView();
    GeneralView generalView = new GeneralView();

    @Override
    public void displayOptions() {
        System.out.println();
        System.out.println("1. Account");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
        option = readOption();

        while (option != Constants.EXIT_OPTION) {
            processOption(option);
            displayOptions();
        }

    }

    @Override
    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    @Override
    public void processOption(int option) {
        switch (option) {
            case 1:
                accountView.displayOptions();
                break;
            case 2:
                generalView.proceesLogOut();
                System.exit(0);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
    }
}
