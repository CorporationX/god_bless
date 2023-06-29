package wallmart_queue;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final String[] customerItems;

    @Override
    public void run() {
        int processedItems = 0;
        double totalCost = 0;

        for (String item : customerItems) {
            double itemCost = calculateItemCost(item);
            totalCost += itemCost;
            processedItems++;
            System.out.println("Cashier " + cashierId + " processed item: " + item + " (Cost: $" + itemCost + ")");
        }

        System.out.println("Cashier " + cashierId + " processed " + processedItems + " items.");
        System.out.println("Total cost for Cashier " + cashierId + ": $" + totalCost);
    }

    private double calculateItemCost(String item) {
        if (item.equalsIgnoreCase("apple")) {
            return 0.5;
        } else if (item.equalsIgnoreCase("banana")) {
            return 0.25;
        } else if (item.equalsIgnoreCase("orange")) {
            return 0.75;
        } else {
            return 0; // unknown item, cost is 0
        }
    }
}
