package org.example;

import java.util.*;
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

class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.api.jar");
        try {
            String name;
            boolean flag = true;
            double accNum;
            double balance;
            String s;
            int choice;
            Scanner sc = new Scanner(System.in);
            logger.info("Enter Customer name : ");
            name = sc.nextLine();
            logger.info("Enter Account number : ");
            accNum = sc.nextDouble();
            logger.info("Enter initial Balance : ");
            balance = sc.nextDouble();
            MyBankAccount bb = new MyBankAccount(name, accNum, balance);
            s = "Welcome " + bb.getName() + ".";
            logger.info(s);
            s = "Your Account balance when your account is created : " + bb.balance() + ".";
            logger.info(s);
            while (flag) {
                int money;
                s = "1. Deposit" + "\n2. Withdraw" + "\n3. Balance" + "\n4. Exit" + "\nEnter your choice : ";
                logger.info(s);
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
                        s = "Your Balance is : " + bb.balance() + ".";
                        logger.info(s);
                        break;
                    default:
                        flag = false;
                        break;
                }
            }
            sc.close();
        }
        catch (Exception e) {
            logger.info("Something went wrong while giving input");
        }
    }
}

