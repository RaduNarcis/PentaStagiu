package view;

import application.ApplicationContext;
import commons.AccountType;
import configuration.Config;
import model.Account;
import service.account.AccountServiceImpl;

import java.util.Scanner;


public class AccountView implements DisplayView {

    int option = -1;

    Account account = new Account();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    AccountDisplayer accountDisplayer = new AccountDisplayer();

    PaymentView paymentView = new PaymentView();

    @Override
    public void displayOptions() {
        System.out.println();
        System.out.println("1. Create Account");
        System.out.println("2. Display Accounts");
        System.out.println("3. Account payments");
        System.out.println("0. Back");

        option = readOption();
        while (option != Config.EXIT_OPTION) {
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
                accountServiceImpl.addAccount(account);
                ApplicationContext.loggedInUserAccounts = accountServiceImpl.listUserAccounts(ApplicationContext.loggedInUser.getUserName());
                return;
            case 2:
                accountDisplayer.listAccounts(ApplicationContext.loggedInUserAccounts);
                return;
            case 3:
                paymentView.displayOptions();
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public Account processCreateNewAccount() {

        Scanner scanner = new Scanner(System.in);

        account.setName(ApplicationContext.loggedInUser.getUserName());

        System.out.println("IBAN: ");
        account.setAccountNumber(scanner.next());

        System.out.println("Amount: ");
        account.setAmount(scanner.nextBigDecimal());
        scanner.nextLine();

        System.out.println("Account type: ");
        String accountTypeAsString = scanner.nextLine();
        AccountType accountType = AccountType.valueOf(accountTypeAsString);
        account.setAccountType(accountType);
        System.out.println("Account type selected " + accountType.name() + " - " + accountType.value);

        return account;
    }
}

