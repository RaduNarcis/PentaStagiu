package view;
import constant.Constants;
import service.ReadUser;


import java.util.Scanner;

public class GeneralView implements MyView{

    int option = -1;

    UserLogInView userLogInView = new UserLogInView();

    public void displayOptions() {
        System.out.println();
        System.out.println("1. Log in");
        System.out.println("2. Exit");
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
                ReadUser.userLogIn();
                return;
            case 2:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
