package service;

import java.math.BigDecimal;

public class BankTransferService {

    Long idAccountFrom;

    Long idAccountTo;

    BigDecimal amount;

    public BankTransferService(Long idAccountFrom, Long idAccountTo, BigDecimal amount) {
        this.idAccountFrom = idAccountFrom;
        this.idAccountTo = idAccountTo;
        this.amount = amount;
    }

    public Long getIdAccountFrom() {
        return idAccountFrom;
    }

    public Long getIdAccountTo() {
        return idAccountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
