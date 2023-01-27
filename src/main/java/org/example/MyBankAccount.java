package org.example;

import java.util.*;
import java.util.logging.Logger;

public class MyBankAccount {
    Logger logger = Logger.getLogger("com.api.jar");
    private String name;
    private double accNum;
    private double balance;

    MyBankAccount(String name, double accNum, double balance) {
        this.name = name;
        this.accNum = accNum;
        this.balance = balance;
    }

    void deposit(int money) {
        balance += money;
        logger.info("Money credited to your account : " + money + ".");
        logger.info("Current Balance : " + balance + ".");
    }

    void withdraw(int money) {
        if (balance < money) {
            logger.info("Your balance is too low to withdraw the amount you requested.");
            logger.info("Your current balance : " + balance + ". But you requested " + money + ".");
        } else {
            balance -= money;
            logger.info("Money debited from your account : " + money + ".");
            logger.info("Current Balance : " + balance + ".");
        }
    }

    double balance() {
        return balance;
    }

    String getName() {
        return name;
    }

}

class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.api.jar");
        String name;
        boolean flag = true;
        double accNum;
        double balance;
        int choice;
        Scanner sc = new Scanner(System.in);
        logger.info("Enter Customer name : ");
        name = sc.nextLine();
        logger.info("Enter Account number : ");
        accNum = sc.nextDouble();
        logger.info("Enter initial Balance : ");
        balance = sc.nextDouble();
        MyBankAccount bb = new MyBankAccount(name, accNum, balance);
        logger.info("Welcome " + bb.getName() + ".");
        logger.info("Your Account balance when your account is created : " + bb.balance() + ".");
        while (flag) {
            int money;
            logger.info("");
            logger.info("1. Deposit" + "\n2. Withdraw" + "\n3. Balance" + "\n4. Exit" + "\nEnter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    logger.info("Enter money to deposit in your account : ");
                    money = sc.nextInt();
                    bb.deposit(money);
                    break;
                case 2:
                    logger.info("Enter money to withdraw from your account : ");
                    money = sc.nextInt();
                    bb.withdraw(money);
                    break;
                case 3:
                    logger.info("Your Balance is : " + bb.balance() + ".");
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        sc.close();
    }
}

