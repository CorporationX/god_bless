package school.faang.bjs248203;

import java.util.Random;

public class Main {

    private static final int CASHIERS = 2;

    public static void main(String[] args) throws Exception {
        int[][] customers = {
                {100, 200, 50},
                {300, 150},
                {400, 100, 200, 50},
                {1, 3, 2, 4},
                {6, 5, 4, 3, 2, 1}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        Random random = new Random();

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(CASHIERS) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("All cashiers have done their jobs.");
    }

}
