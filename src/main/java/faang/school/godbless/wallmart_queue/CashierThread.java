package faang.school.godbless.wallmart_queue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread{
    private int cashierId;
    private int[] items;

    @Override
    public void run() {
        int total = 0;
        for (int i = 0; i < items.length; i++){
            total += items[i];
        }

        System.out.println("Cashier: " + cashierId + ", total: " + total);
    }
}
