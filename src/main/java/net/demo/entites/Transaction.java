package net.demo.entites;

import net.demo.enums.TransactionType;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private double amount;
    private LocalDate date;
    private TransactionType type;
    private Account account;

    public Transaction(double amount, LocalDate date, TransactionType type, Account account) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Transaction that)) return false;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(date, that.date) && type == that.type && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date, type, account);
    }

    @Override
    public String toString() {
        String sign = type == TransactionType.WITHDRAWAL ? "-" : "";
        return "Date= " + date + " ||" + " Amount = " + sign + amount + " ||" + " Balance = " + account.getBalance();
    }
}
