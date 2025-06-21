package school.faang.bjs2_81263;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        log.info("Кассир {} начал обслуживание покупателя с {} товарами.", cashierId, customerItems.length);
        int totalItems = 0;
        int totalPrice = 0;
        int itemCost = 10;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * itemCost;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.error("Ошибка при обслуживании покупателя.", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        log.info("Кассир {} завершил обслуживание. Обработано товаров: {}," +
                "общая стоимость: {}", cashierId, totalItems, totalPrice);
    }
}
