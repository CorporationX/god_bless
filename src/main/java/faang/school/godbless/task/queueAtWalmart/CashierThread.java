package faang.school.godbless.task.queueAtWalmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int soldItemsCount;
    private int soldItemsPrice;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
        this.soldItemsCount = 0;
        this.soldItemsPrice = 0;
    }

    @Override
    public void run() {
        for (int item : customerItems) {
            soldItemsCount++;
            soldItemsPrice += item;
        }
    }
}
