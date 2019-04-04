package view;

import application.ApplicationContext;
import commons.AccountType;
import constant.ViewUtil;
import model.Account;
import service.AccountServiceImpl;

import java.util.Scanner;

public class AccountView implements DisplayView {

    int option = -1;

    AccountServiceImpl accountService = new AccountServiceImpl();

    AccountDisplayer accountDisplayer = new AccountDisplayer();

    @Override
    public void displayOptions() {
        System.out.println();
        System.out.println("1. Create Account");
        System.out.println("2. Display Account");
        System.out.println("3. Transfer Amount");
        System.out.println("0. Back");

        option = readOption();
        while (option != ViewUtil.EXIT_OPTION) {
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
                Account account = processCreateNewAccount();
                accountService.addAccount(account);
                //update current user accounts
                ApplicationContext.loggedInUserAccounts = AccountServiceImpl.listUserAccounts(ApplicationContext.loggedInUser.getUserName());
                return;
            case 2:
                /*
                List<Account> accounts = accountService.listAllAcounts();
                accountDisplayer.listUserAccounts(accounts);
                */
                accountDisplayer.listAccounts(ApplicationContext.loggedInUserAccounts);
                return;
            case 3:
                // iei datele de transfer
                // accountService.processTransfer()
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void processTransfer(){

    }

    public Account processCreateNewAccount() {

        Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Id: ");
        account.setId(scanner.nextLong());

        System.out.println("IBAN: ");
        account.setAccountNumber(scanner.next());

        System.out.println("User name: ");
        account.setName(scanner.next());

        System.out.println("Amount: ");
        account.setAmount(scanner.nextBigDecimal());

        System.out.println("Account type: ");
        //account.setAccountType().value;

        return account;
    }
}

