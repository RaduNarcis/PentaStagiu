import java.util.Scanner;

public class Menu {

    private final int EXIT_OPTION = 0;

    public void displayMenu() {
        int option = -1;
        displayOptions();
        option = readOption();
        processOption(option);
        if (option != EXIT_OPTION) {
            displayMenu();

        }
    }

    public int readOption() {
        System.out.println("Option: ");
        return new Scanner(System.in).nextInt();

    }

    private void displayOptions() {
        System.out.println();
        System.out.println("1. Log in");
        System.out.println("2. Exit");

    }

    private void logIn() {

    }

    private void processOption(int option) {

        switch (option) {
            case 1:
                logIn();
                break;
            case 2:
            default:
        }
    }
}
