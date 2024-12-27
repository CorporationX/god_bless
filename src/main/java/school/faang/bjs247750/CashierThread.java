package school.faang.bjs247750;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class CashierThread extends Thread {

    private final int cashierId;
    private final Map<String, Integer> customerItems;

    @Override
    public void run() {
        log.info("The cashier {} began serving the customer with {} items", cashierId, customerItems.size());

        int totalItems = 0;
        int totalPrice = 0;

        for (Map.Entry<String, Integer> entry : customerItems.entrySet()) {
            int item = entry.getValue();
            totalItems++;
            totalPrice += item * 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("The thread was interrupted while waiting for the thread to complete {}", e.getMessage());
            }
        }

        log.info("The cashier {} finished serving. Products processed: {}, total cost: {}", cashierId, totalItems, totalPrice);
    }
}