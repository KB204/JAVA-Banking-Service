package net.demo;

import net.demo.entites.Account;
import net.demo.service.AccountService;
import net.demo.service.impl.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1,50);
        AccountService accountService = new AccountServiceImpl(account);

        System.out.println("*******************************************************");

        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        accountService.printStatements();

        System.out.println("*******************************************************");
    }
}