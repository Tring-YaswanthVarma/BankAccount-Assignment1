package org.example;

import java.util.logging.Logger;

public class MyBankAccount {
    Logger logger = Logger.getLogger("com.api.jar");
    private String name;
    private double accNum;
    private double balance;
    private String s;

    MyBankAccount(String name, double accNum, double balance) {
        this.name = name;
        this.accNum = accNum;
        this.balance = balance;
    }

    void deposit(int money) {
        balance += money;
        s = "Money credited to your account : " + money + ".";
        logger.info(s);
        s = "Current Balance : " + balance + ".";
        logger.info(s);
    }

    void withdraw(int money) {
        if (balance < money) {
            s = "Your balance is too low to withdraw the amount you requested.";
            logger.info(s);
            s = "Your current balance : " + balance + ". But you requested " + money + ".";
            logger.info(s);
        } else {
            balance -= money;
            s = "Money debited from your account : " + money + ".";
            logger.info(s);
            s = "Current Balance : " + balance + ".";
            logger.info(s);
        }
    }

    double balance() {
        return balance;
    }

    String getName() {
        return name;
    }

}


