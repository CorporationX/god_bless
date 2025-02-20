package school.faang.sprint3.task_60622;

import java.util.Random;

public class Main {
    private static final int NUM_OF_CASHIERS = 3;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(NUM_OF_CASHIERS) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All cashiers have finished their work.");
    }
}
