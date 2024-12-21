package school.faang.task47778;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;


@Slf4j
public class Main {
    public static void main(String[] args) {
        int[][] customers = {
                {1, 2, 3, 4},
                {6, 5, 6},
                {3, 4, 1},
                {10, 2, 1, 3, 5}
        };

        int numCashiers = 3;

        CashierThread[] cashiers = new CashierThread[customers.length];


        Random random = new Random();

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(numCashiers) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        log.info("All cashiers have completed their work");
    }
}