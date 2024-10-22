package ru.kraiush.BJS2_36262;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Item[][] customers = {
                {
                        new Item("Bread", 2.49),
                        new Item("Milk", 3.79),
                        new Item("Chocolate bar", 1.99),
                        new Item("Groud beef", 12.99)
                },
                {
                        new Item("Chicken breast", 12.88),
                        new Item("Dill", 0.99),
                        new Item("Curry sause", 3.59)
                },
                {
                        new Item("Cheese", 7.59),
                        new Item("Ham", 3.49)
                },
                {
                        new Item("Coke", 4.99),
                        new Item("Wine", 15.99),
                        new Item("Cheese", 7.59)
                },
                {
                        new Item("Milk", 3.79),
                        new Item("Wine", 15.99),
                        new Item("Chocolate bar", 1.99),
                        new Item("Bread", 2.49)
                }
        };

        CashierThread[] cashiers = new CashierThread[customers.length];
        int cashiersQuantity = 3;

        for (int i = 0; i < customers.length; ++i) {
            CashierThread cashier = new CashierThread(new Random().nextInt(cashiersQuantity) + 1, customers[i]);
            cashier.start();
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.out.println("The process was interrupted!");
            }
        }

        System.out.println("All cashiers finished their work!");
    }
}
