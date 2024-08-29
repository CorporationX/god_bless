package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int totalItems = customerItems.length;
        int totalCost = Arrays.stream(customerItems).sum();

        System.out.println("Cashier " + cashierId + " processed " + totalItems + " items. Total cost: " + totalCost);
    }
}
