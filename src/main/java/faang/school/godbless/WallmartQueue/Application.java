package faang.school.godbless.WallmartQueue;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {{5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}};

        CashierThread[] cashierThreads = new CashierThread[3];
        for (int i = 0; i < cashierThreads.length; i++) {
            cashierThreads[i] = new CashierThread(i + 1, customers[i]);
        }

        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.start();
        }

        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.join();
        }

        int overallQuantity = customers.length * customers[0].length;
        int overallPrice=  Arrays.stream(customers).flatMapToInt(Arrays::stream).sum();
        System.out.println("Products quantity: " + overallQuantity
                + " Products price: " + overallPrice);
    }
}
