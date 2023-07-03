package Multithreading.bc2314;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int price;
    private int countItem;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (Integer item : customerItems) {
            this.price += item;
            this.countItem++;
            System.out.println("Cashier № " + getCashierId() + " handled: " + item);
        }
    }
}
