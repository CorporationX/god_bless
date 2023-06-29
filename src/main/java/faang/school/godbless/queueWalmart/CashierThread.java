package faang.school.godbless.queueWalmart;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CashierThread extends Thread{

    private final int cashierId;

    private int[] customerItems;

    public CashierThread(int cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public void run() {
        int totalItems = 0;
        int totalPrice = 0;
        for (int item : customerItems) {
            totalItems++;
            totalPrice += item;
            try {
                Thread.sleep(item * 300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cashier " + cashierId + " processed " + totalItems + " items with a total cost of " + totalPrice);
    }
}


