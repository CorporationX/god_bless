package school.faang;

import java.util.Random;

public class Main {
    private static final int NUMBER_OF_CASHIERS = 3;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; ++i) {
            int cashierId = random.nextInt(NUMBER_OF_CASHIERS);
            cashiers[i] = new CashierThread(cashierId, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.println("All cashiers completed work.");
    }
}
