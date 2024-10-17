package school.faang.walmart.main;

import school.faang.walmart.maincode.CashierThread;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {2, 3, 4},
                {5, 5, 5},
                {3, 4, 6},
                {5, 7, 1, 8}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        int cushersCount = 3;

        for (int i = 0; i < customers.length; i++) {
            Random random = new Random();

            int cushierId = random.nextInt(cushersCount) + 1;
            cashiers[i] = new CashierThread(cushierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
    }
}
