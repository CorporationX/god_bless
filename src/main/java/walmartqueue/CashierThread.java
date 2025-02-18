package walmartqueue;

import lombok.Getter;

import java.util.logging.Logger;

@Getter
public class CashierThread extends Thread implements Runnable {
    private static final Logger logger = Logger.getLogger(CashierThread.class.getName());
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int totalCost = 0;
        logger.info("Cashier " + cashierId + " started serving a customer with " + customerItems.length + " items.");
        for (int i = 0; i < customerItems.length; i++) {
            int itemCost = customerItems[i] * 50;
            totalCost += itemCost;
            logger.info(threadName + ": Cashier " + cashierId + " processed item " + (i + 1) + " costing " + itemCost);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.info("Cashier " + cashierId + " was interrupted.");
            }
        }
        logger.info("Cashier " + cashierId + " finished serving. Total cost: " + totalCost);
    }
}
