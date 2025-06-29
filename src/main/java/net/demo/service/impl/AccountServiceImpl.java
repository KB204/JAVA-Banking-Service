package net.demo.service.impl;

import net.demo.entites.Account;
import net.demo.entites.Transaction;
import net.demo.enums.TransactionType;
import net.demo.exceptions.BankAccountException;
import net.demo.service.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private final Account account;

    public AccountServiceImpl(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        var transaction = new Transaction(amount, LocalDate.now(),TransactionType.DEPOSIT,account);
        checkTransaction(transaction);

        double accountBalance = account.getBalance();
        account.setBalance(accountBalance + amount);
        transactions.add(transaction);
    }

    @Override
    public void withdraw(double amount) {
        var transaction = new Transaction(amount, LocalDate.now(), TransactionType.WITHDRAWAL,account);
        checkTransaction(transaction);
        checkTransaction(account,amount);

        double accountBalance = account.getBalance();
        account.setBalance(accountBalance - amount);
        transactions.add(transaction);
    }

    @Override
    public void printStatements() {
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .forEach(System.out::println);
    }

    private void checkTransaction(Transaction transaction) {
        if (transaction.getAmount() <= 0)
            throw new BankAccountException("The transaction amount must be greater than zero");
    }

    private void checkTransaction(Account account, double amount) {
        if (account.getBalance() < amount)
            throw new BankAccountException("The account balance is not enough to make the transaction");
    }
}
