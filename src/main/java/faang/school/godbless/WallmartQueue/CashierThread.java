package faang.school.godbless.WallmartQueue;

import java.util.Arrays;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(customerItems.length);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int item : this.customerItems) {
            System.out.println(item + " proceeded by cashier with id " + this.cashierId);
        }
        System.out.println("Total price of all items " + Arrays.stream(customerItems).sum());
    }
}
