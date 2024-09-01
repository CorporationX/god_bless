package faang.school.godbless.cashier;

import java.util.Random;

public class Walmart {
    public static void main(String[] args) {
        final int[][] customers = {
                {10, 15, 20},
                {5, 8, 12, 3},
                {25, 40},
                {7, 2, 9, 4, 5},
                {50, 30},
        };

        final CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].start();
        }

        for (int i = 0; i < cashiers.length; i++) {
            try {
                cashiers[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Главный поток был прерван во время ожидания.");
            }
        }

        System.out.println("Все кассиры завершили обслуживание покупателей. Работа магазина завершена.");
    }
}
