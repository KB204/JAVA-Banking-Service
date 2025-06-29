package net.demo.service;

public interface AccountService {
    void deposit(double amount);
    void withdraw(double amount);
    void printStatements();
}
