package school.faang.Mnogopotochka.ParallelismThread.BJS2_36256;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int[][] customers = {
                {100, 200, 150},
                {50, 75, 125},
                {200, 300},
                {80, 120, 160, 40}
        };

        for (int[] customer : customers) {
            if (customer == null || customer.length == 0) {
                logger.error("Error: Customer data is invalid.");
                return;
            }
        }

        CashierThread[] cashiers = new CashierThread[customers.length];
        Random random = new Random();

        for (int i = 0; i < customers.length; i++) {
            int cashierId = random.nextInt(3) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            logger.info("Starting cashier {}", cashier.getCashierId());
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
                logger.info("Cashier {} has finished processing.", cashier.getCashierId());
            } catch (InterruptedException e) {
                logger.error("Error: Cashier {} was interrupted.", cashier.getCashierId(), e);
            }
        }
    }
}
