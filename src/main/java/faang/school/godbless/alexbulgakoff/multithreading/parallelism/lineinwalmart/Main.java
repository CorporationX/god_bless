package faang.school.godbless.alexbulgakoff.multithreading.parallelism.lineinwalmart;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        int sumItemPrice = 0;
        int itemCount = 0;
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
            for (int j = 0; j < customers[i].length; j++) {
                sumItemPrice += customers[i][j];
            }
            itemCount += customers[i].length;
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Обработано "  + itemCount + " товаров, общей стоимостью: " + sumItemPrice + " руб.");
    }
}
