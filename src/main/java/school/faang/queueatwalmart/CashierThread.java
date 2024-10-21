package school.faang.queueatwalmart;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        int totalItems = customerItems.length;
        int totalCost = Arrays.stream(customerItems).sum();

        System.out.println("Cashier " + cashierId + " is processing " + totalItems + " items.");

        Arrays.stream(customerItems).forEach(item -> {
            try {
                System.out.println("Cashier " + cashierId + " processed item priced at $" + item);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Cashier " + cashierId + " was interrupted while processing.");
            }
        });

        System.out.println("Cashier " + cashierId + " finished processing " + totalItems + " items. Total cost: $" + totalCost);
    }
}
