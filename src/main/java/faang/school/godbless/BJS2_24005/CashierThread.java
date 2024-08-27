package faang.school.godbless.BJS2_24005;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private Item[] customerItems ;

    @Override
    public void run() {
        int count = 0, sumPrice = 0;
        for (Item item : customerItems) {
            System.out.printf("Касса: %d: %s%n", cashierId, item);

            count++;
            sumPrice += item.getPrice();
        }

        System.out.printf("Nтог у кассы: %s количество товаров: %d сумма платежа: %d%n", cashierId, count, sumPrice);
    }
}
