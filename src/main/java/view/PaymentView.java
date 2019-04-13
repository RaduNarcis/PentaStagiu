package view;

import application.ApplicationContext;
import configuration.Config;
import service.BankTransferService;
import service.account.AccountServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentView implements DisplayView {

    int option = -1;

    AccountDisplayer accountDisplayer = new AccountDisplayer();

    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    @Override
    public void displayOptions() {
        System.out.println("1. Tranfer Amount");
        System.out.println("2. Display Account");
        System.out.println("0. Back ");

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
                BankTransferService bankTransfer = processTransfer();
                accountServiceImpl.transferAmount(bankTransfer);
                return;
            case 2:
                accountDisplayer.listAccounts(ApplicationContext.loggedInUserAccounts);
                return;
            case 0:
                System.exit(0);
                return;
             default:
                 break;
        }
    }


    public BankTransferService processTransfer() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("From account ID: ");
        Long accFromId = scanner.nextLong();

        System.out.println("To account ID: ");
        Long accToId = scanner.nextLong();

        System.out.println("Amount:");
        BigDecimal amountToTransfer = scanner.nextBigDecimal();

        BankTransferService bankTransfer = new BankTransferService(accFromId, accToId, amountToTransfer);
        return bankTransfer;
    }
}
