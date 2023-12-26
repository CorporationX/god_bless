package faang.school.godbless.multi_paral.task10walmart;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private Item[] customerItems;

    @Override
    public void run() {
        int totalItems = 0;
        int totalPrice = 0;

        for (Item item : customerItems) {
            totalItems++;
            totalPrice += item.getPrice();
            System.out.println( "Кассир " + cashierId + " обработал товар '" + item.getName() + "' c ценной " + item.getPrice());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Обработка прервана");
            }
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Кассир " + cashierId + " обработал " + totalItems + " товаров на сумму " + totalPrice);
        System.out.println("--------------------------------------------------------------------------");

    }
}

