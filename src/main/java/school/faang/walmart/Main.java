package school.faang.walmart;

import java.util.Random;

public class Main {
    private static final int NUM_CASHIERS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };
        int numCustomers = customers.length;
        CashierThread[] cashiers = new CashierThread[numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            int cashierId = random.nextInt(NUM_CASHIERS) + 1;
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

        System.out.println("Все кассиры завершили работу.");
    }
}
