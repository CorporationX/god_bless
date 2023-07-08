package faang.school.godbless.Multithreading.ParallelismAndThread.task07_Walmart;

import lombok.Data;
import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int totalPrice = 0;
    private int itemsCount = 0;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public int randomPrice(){
        return (int) (200 * Math.random());
    }
    @Override
    public void run() {
        System.out.println("Касса " + cashierId + " обслуживает покупателя");
        for (int i = 0; i < customerItems.length; i++) {
            for (int item : customerItems) {
                System.out.println("Обработан товар " + item + " на кассе " + cashierId);
                itemsCount++;
                totalPrice += customerItems[i]*randomPrice();
                try {
                    Thread.sleep(1550);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Полная стоимость всех товаров на кассе " + cashierId + " составляет " + totalPrice);
        }
    }
}
