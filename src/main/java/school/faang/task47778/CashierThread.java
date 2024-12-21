package school.faang.task47778;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        log.info("Cashier {} starter serving{}", cashierId, customerItems);
        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Cashier {} completed the service. Processed items {} total cost {}",
                cashierId, totalItems, totalPrice);
    }
}
