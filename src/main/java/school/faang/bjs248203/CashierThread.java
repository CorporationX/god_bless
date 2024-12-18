package school.faang.bjs248203;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {

    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        System.out.println("Cashier " + cashierId + " started processing items.");
        int totalItems = customerItems.length;
        int totalCost = 0;

        for (int i = 0; i < customerItems.length; i++) {
            int itemCost = customerItems[i];
            totalCost += itemCost;
            System.out.println("Cashier " + cashierId + " processed item " + (i + 1) + ", cost: " + itemCost);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cashier " + cashierId + " finished processing " + totalItems + " items.");
        System.out.println("Total cost: " + totalCost + " units.");
    }

}
