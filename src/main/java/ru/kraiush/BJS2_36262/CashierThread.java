package ru.kraiush.BJS2_36262;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private Item[] customerItems;

    @Override
    public void run() {
        System.out.println("Cashier #" + cashierId + " started to serve the customer with " + customerItems.length + " goods.");
        int totalQuantity = 0;
        double totalCost = 0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Item item : customerItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            totalQuantity++;
            totalCost += item.getPrice();
        }
        System.out.println("Cashier #" + cashierId + " finished serving. Total quantity of goods: " + totalQuantity + ", total cost: " + totalCost + "\n");
    }
}
