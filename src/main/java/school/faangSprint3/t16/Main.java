package school.faangSprint3.t16;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };

        int numCashiers = 3;
        CashierThread[] cashiers = new CashierThread[customers.length];
        Random random = new Random();

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(numCashiers) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        try {
            for (CashierThread cashier : cashiers) {
                cashier.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все кассиры завершили работу.");
    }
}