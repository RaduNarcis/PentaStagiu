package view;

import service.ReadUser;

import java.util.Scanner;

public class UserLogInView implements MyView {

    int option = -1;

    @Override
    public void displayOptions() {
        System.out.println();
        System.out.println("1. Log out");
        System.out.println("0. Exit");
        option = readOption();

        while (option != EXIT_OPTION) {
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
                ReadUser.userLogOut();
                return;
            case 2:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
