package school.faang.Mnogopotochka.ParallelismThread.BJS2_36256;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(CashierThread.class);

    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        if (customerItems == null || customerItems.length == 0) {
            logger.error("Cashier {} has no items to process.", cashierId);
            return;
        }

        int totalItems = 0;
        int totalCost = 0;

        for (int itemCost : customerItems) {
            if (itemCost < 0) {
                logger.error("Cashier {} encountered an item with negative cost: {}", cashierId, itemCost);
                continue;
            }
            logger.info("Cashier {} processing item with cost: {}", cashierId, itemCost);
            totalItems++;
            totalCost += itemCost;
        }

        logger.info("Cashier {} processed {} items. Total cost: {}", cashierId, totalItems, totalCost);
    }
}