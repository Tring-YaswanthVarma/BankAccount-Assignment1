package org.example;

import java.util.*;

public class MyBankAccount {
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
        System.out.println("Money credited to your account : " + money + ".");
        System.out.println("Current Balance : " + balance + ".");
    }

    void withdraw(int money) {
        if (balance < money) {
            System.out.println("Your balance is too low to withdraw the amount you requested.");
            System.out.println("Your current balance : " + balance + ". But you requested " + money + ".");
        } else {
            balance -= money;
            System.out.println("Money debited from your account : " + money + ".");
            System.out.println("Current Balance : " + balance + ".");
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
        String name;
        boolean flag = true;
        double accNum, balance;
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer name : ");
        name = sc.nextLine();
        System.out.println("Enter Account number : ");
        accNum = sc.nextDouble();
        System.out.println("Enter initial Balance : ");
        balance = sc.nextDouble();
        MyBankAccount bb = new MyBankAccount(name, accNum, balance);
        System.out.println("Welcome " + bb.getName() + ".");
        System.out.println("Your Account balance when your account is created : " + bb.balance() + ".");
        while (flag) {
            int money;
            System.out.println();
            System.out
                    .println("1. Deposit" + "\n2. Withdraw" + "\n3. Balance" + "\n4. Exit" + "\nEnter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter money to deposit in your account : ");
                    money = sc.nextInt();
                    bb.deposit(money);
                    break;
                case 2:
                    System.out.println("Enter money to withdraw from your account : ");
                    money = sc.nextInt();
                    bb.withdraw(money);
                    break;
                case 3:
                    System.out.println("Your Balance is : " + bb.balance() + ".");
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        sc.close();
    }
}

