package model;

import commons.AccountNumberValidator;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Long id;
    private String iban;
    private String name;
    private BigDecimal amount;
    private Double balance;
    private String accountType;

    public Account(){

    }

    public Account(Long id, String iban, String name, BigDecimal amount, Double balance, String accountType) {
        this.id = id;
        this.iban = iban;
        this.name = name;
        this.amount = amount;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        if (AccountNumberValidator.validateIBAN(iban)) {
            this.iban = iban;
        } else {
            throw new IllegalArgumentException("IBAN format is invalid");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
                Objects.equals(getIban(), account.getIban()) &&
                Objects.equals(getName(), account.getName()) &&
                Objects.equals(getAmount(), account.getAmount()) &&
                Objects.equals(getBalance(), account.getBalance()) &&
                Objects.equals(getAccountType(), account.getAccountType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIban(), getName(), getAmount(), getBalance(), getAccountType());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
