package school.faang.bjs2_72998;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int CASHIERS_COUNT = 5;
    private static final int CUSTOMERS_COUNT = 15;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5},
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5},
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5},
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2}
        };
        CashierThread[] cashiers = new CashierThread[CUSTOMERS_COUNT];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(random.nextInt(CASHIERS_COUNT), customers[i]);
        }

        for (int i = 0; i < CASHIERS_COUNT; i++) {
            final int id = i;
            var list = Arrays.stream(cashiers)
                    .filter(cashier -> cashier.getCashierId() == id)
                    .toList();

            new Thread(() -> {
                try {
                    for (CashierThread cashierThread : list) {
                        cashierThread.start();
                        cashierThread.join();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}