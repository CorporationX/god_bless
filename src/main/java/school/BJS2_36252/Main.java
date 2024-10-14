package school.BJS2_36252;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        int[][] customers = {{12, 4, 5, 7}, {15, 2, 54, 2}, {15, 1, 67}, {11, 24, 52}};

        List<CashierThread> cashierThreads = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {
            int cashier = new Random().nextInt(4) + 1;
            CashierThread cashierThread = new CashierThread(cashier, customers[i]);
            cashierThreads.add(cashierThread);
        }
        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.start();
        }
        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.join();
        }
        System.out.println("Все товары обработаны");
    }
}
