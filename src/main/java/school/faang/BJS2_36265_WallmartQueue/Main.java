package school.faang.BJS2_36265_WallmartQueue;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final int CASHIERS_AMOUNT = 2;

    public static void main(String[] args) {
        int[][] customersItemsQuantities = {
                {7, 4, 9, 12, 3},
                {8, 15, 6, 10, 2, 5, 13, 7},
                {3, 11, 2, 8, 14},
                {9, 4, 12, 6, 5},
                {1, 10, 7, 3, 19},
        };

        CashierThread[] cashierThreads = new CashierThread[customersItemsQuantities.length];
        for (int i = 0; i < customersItemsQuantities.length; i++) {
            int cashierId = ThreadLocalRandom.current().nextInt(CASHIERS_AMOUNT) + 1;
            CashierThread cashierThread = new CashierThread(cashierId, customersItemsQuantities[i]);
            cashierThreads[i] = cashierThread;
            cashierThread.start();
        }

        Arrays.stream(cashierThreads).forEach(cashierThread -> {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(
                        String.format(
                                "Main thread was interrupted while waiting for cashier thread (%s) to finish.\n",
                                cashierThread.getName()
                        ),
                        e
                );
            }
        });

        System.out.println("All cashiers have done their work!");
    }
}
