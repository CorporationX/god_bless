package school.faang.walmart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        log.info("Кассир {} начал обслуживание покупателя с {} товарами.", cashierId, customerItems.length);

        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10; // Каждый товар условно стоит 10 единиц

            try {
                Thread.sleep(500); // Симуляция обработки одного товара (0.5 секунды)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        log.info("Кассир {} завершил обслуживание. Обработано товаров: {}, общая стоимость: {}",
                cashierId, totalItems, totalPrice);
    }
}
