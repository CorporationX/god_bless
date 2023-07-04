package faang.school.godbless.threads.walmart;

import lombok.Getter;

import java.util.List;

@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> itemList;

    private int countItems = 0;
    private int priceSum = 0;
    public CashierThread(int cashierId, List<Item> itemList) {
        this.cashierId = cashierId;
        this.itemList = itemList;
    }

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " начинает пробивать товары...");
        for (Item item : itemList) {
            countItems++;
            priceSum += item.getPrice();
            System.out.println("Товар " + item.toString() + " пробит кассиром " + cashierId);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("Кассир %s пробил %d шт товаров на сумму %d\n", cashierId, countItems, priceSum);
    }
}
