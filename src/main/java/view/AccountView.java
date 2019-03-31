package view;

import constant.Constants;
import model.Account;
import reader.NewAccount;
import service.AccountService;
import view.displayer.AccountDisplayer;

import java.util.List;
import java.util.Scanner;

public class AccountView implements DisplayView {

    int option = -1;
    AccountService accountService = new AccountService();
    NewAccount newAccount = new NewAccount();
    AccountDisplayer accountDisplayer = new AccountDisplayer();

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
                accountService.addAccount(newAccount.createNewAccount());
                return;
            case 2:
                List<Account> accounts = accountService.listAllAcounts();
                accountDisplayer.listAccounts(accounts);
                return;
            case 0:
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
    }
}

