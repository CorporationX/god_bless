package school.faang.bjs2_89989;

import java.util.Random;

public class Main {
    public static final int NUMBER_OF_CASHIERS = 2;
    public static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {23, 15, 7, 2},
                {9, 12, 1, 16},
                {3, 20},
                {24, 98, 15, 43, 90}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(NUMBER_OF_CASHIERS) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("Кассиры закончили обслуживать покупателей.");
    }
}
