package model;

public class BankAccount {

    private int nrOfAccounts = 0;
    private Account[] bankAccount;
    private int capacity = bankAccount.length;

    public BankAccount(int nrOfAccounts) {
        bankAccount = new Account[nrOfAccounts];
    }

    public void diplayAccounts() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(bankAccount[i]);
        }
    }

    public void addAccount(Account account) {
        bankAccount[nrOfAccounts] = account;
        nrOfAccounts++;
    }
}
