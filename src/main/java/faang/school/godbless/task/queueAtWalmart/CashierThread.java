package faang.school.godbless.task.queueAtWalmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private int[] customerItems;
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

    public static void main(String[] args) {
        int[][] customerItems = new int[][]{
                {1, 2, 3, 4, 5},
                {11, 12, 13},
                {21, 22},
                {31, 32, 33, 34}
        };

        CashierThread[] cashiers = new CashierThread[4];

        for (int i = 0; i < customerItems.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customerItems[i]);
        }

        for (var cashier : cashiers) {
            cashier.start();
        }

        for (var cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int soldItemsCount = 0;
        int soldItemsPrice = 0;
        for (var cashier : cashiers) {
            soldItemsCount += cashier.getSoldItemsCount();
            soldItemsPrice += cashier.getSoldItemsPrice();
        }

        System.out.println(soldItemsCount + " items sold for " + soldItemsPrice + "$");
    }
}
