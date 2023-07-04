package faang.school.godbless.parallelismAndThread.queueAtWalmart;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class CashierThread extends Thread {
    @Setter
    private int cashierId;
    @Setter
    private Item[] customerItems;
    private int totalPrice;
    private int totalItems;

    public CashierThread(int cashierId, Item[] customerItems) {
        super();
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Кассир №" + cashierId + " начинает обработку заказа...");

        for (Item item : customerItems) {
            try {
                Thread.sleep((long) (Math.random() * 2000) + 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Кассир №" + cashierId + " обработал товар " + item);
            totalPrice += item.getPrice();
            totalItems++;
        }

        System.out.println("Кассир №" + cashierId + " обработал " + customerItems.length +
                " товаров общей стоимостью: " + totalPrice);
    }
}
