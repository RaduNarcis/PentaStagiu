package model;

import commons.AccountNumberValidator;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Long id;
    private String accountNumber;
    private String name;
    private BigDecimal amount;
    private String accountType;

    public Account() {
    }

    public Account(Long id, String iban, String name, BigDecimal amount, String accountType) {
        this.id = id;
        this.accountNumber = iban;
        this.name = name;
        this.amount = amount;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (AccountNumberValidator.validateIBAN(accountNumber)) {
            this.accountNumber = accountNumber;
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
                Objects.equals(getAccountNumber(), account.getAccountNumber()) &&
                Objects.equals(getName(), account.getName()) &&
                Objects.equals(getAmount(), account.getAmount()) &&
                Objects.equals(getAccountType(), account.getAccountType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getName(), getAmount(), getAccountType());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
