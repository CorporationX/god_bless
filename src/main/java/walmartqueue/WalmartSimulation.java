package walmartqueue;

import java.util.Random;
import java.util.logging.Logger;

public class WalmartSimulation {
    private static final Logger logger = Logger.getLogger(WalmartSimulation.class.getName());

    public static void main(String[] args) {
        int numCustomers = 15;
        int numCashiers = 12;
        Random random = new Random();

        int[][] customers = new int[numCustomers][];
        for (int i = 0; i < numCustomers; i++) {
            customers[i] = new int[random.nextInt(20) + 1];
            for (int j = 0; j < customers[i].length; j++) {
                customers[i][j] = random.nextInt(100) + 1;
            }
        }

        CashierThread[] cashiers = new CashierThread[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            int cashierId = random.nextInt(numCashiers) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.severe("Interrupted!!!");
            }
        }
        logger.info("All customers have been served.");
    }
}