package reader;

import model.Account;

import java.util.Scanner;

public class NewAccount {

    public Account createNewAccount() {

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
        account.setAccountType(scanner.next());

        return account;
    }
}
