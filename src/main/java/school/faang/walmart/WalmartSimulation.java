package school.faang.walmart;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class WalmartSimulation {
    private static final int NUM_OF_CASHIERS = 3;
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(NUM_OF_CASHIERS) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
            cashiers[i].start();
        }
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        log.info("Все кассиры завершили работу.");
    }
}
