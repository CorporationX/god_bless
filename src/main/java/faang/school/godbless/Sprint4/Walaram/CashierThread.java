package faang.school.godbless.Sprint4.Walaram;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;
    public int totalCost;
    public int totalAmount;

    @Override
    public synchronized void run() {
        totalAmount = customerItems.length;
        totalCost = Arrays.stream(customerItems).sum();
        System.out.printf("%d\nAll cost - %d, all amount - %d\n", Thread.currentThread().getId(), totalCost, totalAmount);
    }

    CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }
}
