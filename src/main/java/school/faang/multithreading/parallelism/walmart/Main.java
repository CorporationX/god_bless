package school.faang.multithreading.parallelism.walmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };

        List<CashierThread> cashiers = new ArrayList<>();
        for (int i = 0; i < customers.length; i++) {
            cashiers.add(new CashierThread(i + 1, customers[i]));
        }

        cashiers.forEach(CashierThread::start);
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
    }
}
