package faang.school.godbless.walmart;

import java.util.Random;

public class Main {

    private static final int LIMIT_CUSTOMERS = 10;
    private static final int LIMIT_ITEMS = 20;
    private static final int LIMIT_PRICE = 100;
    private static final Random GREAT_RANDOM = new Random();

    public static void main(String[] args) {
        int[][] customers = new int[LIMIT_CUSTOMERS][];

        for (int i = 0; i < customers.length; i++) {
            int itemsCount = GREAT_RANDOM.nextInt(LIMIT_ITEMS);
            customers[i] = new int[itemsCount];

            for (int j = 0; j < customers[i].length; j++) {
                customers[i][j] = GREAT_RANDOM.nextInt(LIMIT_PRICE);
            }
        }

        CashierThread[] cashiers = new CashierThread[LIMIT_CUSTOMERS];
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
        }
    }
}
