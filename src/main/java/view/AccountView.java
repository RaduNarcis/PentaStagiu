package view;

import constant.Constants;
import model.NewAccount;
import service.AccountService;

import java.util.Scanner;

public class AccountView implements MyView {

    int option = -1;
    AccountService accountService = new AccountService();
    NewAccount newAccount = new NewAccount();

    @Override
    public void displayOptions() {
        System.out.println();
        System.out.println("1. Create Account");
        System.out.println("2. Display Account");
        System.out.println("0. Back");

        option = readOption();
        while (option != Constants.EXIT_OPTION){
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
        switch (option){
            case 1:
                newAccount.createNewAccount();
                return;
            case 2:

                return;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}

