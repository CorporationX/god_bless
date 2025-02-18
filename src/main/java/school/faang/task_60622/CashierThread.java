package school.faang.task_60622;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        System.out.printf("Started %d serving the customer with %d the items.\n", cashierId, customerItems.length);

        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.printf("The cashier %d has completed the service. Processed items: %d. Total cost: %d.\n",
                cashierId, totalItems, totalPrice);
    }
}
