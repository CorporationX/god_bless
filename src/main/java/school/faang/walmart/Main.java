package school.faang.walmart;

import java.util.Random;

public class Main {
    private static final int NUMBER_OF_CUSTOMERS = 5;
    private static final int MAX_ITEMS_PER_CUSTOMER = 5;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        int[][] customers = new int[NUMBER_OF_CUSTOMERS][];

        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            int numberOfItems = RANDOM.nextInt(MAX_ITEMS_PER_CUSTOMER) + 1;
            customers[i] = new int[numberOfItems];
            for (int j = 0; j < numberOfItems; j++) {
                customers[i][j] = RANDOM.nextInt(100) + 1;
            }
        }

        CashierThread[] cashiers = new CashierThread[NUMBER_OF_CUSTOMERS];

        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            int cashierId = RANDOM.nextInt(3) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("Все покупатели обслужены!");
    }
}
