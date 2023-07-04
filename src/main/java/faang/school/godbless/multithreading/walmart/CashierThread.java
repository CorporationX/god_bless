package faang.school.godbless.multithreading.walmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final Item[] customerItems;
    private int totalPrice;

    public CashierThread(int cashierId, Item[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Кассир-" + cashierId + " начал работу");

        for (Item item : customerItems) {
            System.out.println("Кассир-" + cashierId + " обрабатывает товар " + item.getName());
            totalPrice += item.getPrice();
        }

        System.out.printf("Кассир-%d обработал %d товаров на сумму: %d\n",
                cashierId, customerItems.length, totalPrice);
    }
}
