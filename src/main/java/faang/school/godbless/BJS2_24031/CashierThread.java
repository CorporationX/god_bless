package faang.school.godbless.BJS2_24031;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CashierThread extends Thread {

    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        System.out.println("Cashier " + cashierId + " started processing the customer...");
        int totalSum = 0;
        for (int item : customerItems) {
            totalSum += item;
        }
        System.out.println("Cashier " + cashierId + " ended - Product's count: " + customerItems.length + ", total sum: " + totalSum);
    }
}
