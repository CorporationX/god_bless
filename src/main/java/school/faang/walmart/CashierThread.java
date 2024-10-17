package school.faang.walmart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private final Item[] customerItems;

    @Override
    public void run() {
        int count = 0;
        int totalCost = 0;
        for (Item item : customerItems) {
            count++;
            totalCost += item.getPrice();
            System.out.println(item);
        }

        System.out.println("Количество товаров: " + count);
        System.out.println("Общая стоимость покупок: " + totalCost);
    }
}
