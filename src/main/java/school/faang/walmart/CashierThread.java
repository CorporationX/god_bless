package school.faang.walmart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
class CashierThread extends Thread {
    private static final int MIN_SLEEP_MS = 500;
    private static final int MAX_SLEEP_MS = 1500;

    private final int cashierId;
    private final Item[] customerItems;
    private double totalCost;

    @Override
    public void run() {
        totalCost = 0;

        for (Item customerItem : customerItems) {
            double itemPrice = customerItem.getPrice();
            totalCost += itemPrice;
            log.info("Кассир {}: пробивает товар {}",
                    cashierId, customerItem);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS));
            } catch (InterruptedException e) {
                log.warn("Кассир {} прерван во время обработки товара!", cashierId);
                Thread.currentThread().interrupt();
                return;
            }
        }

        log.info("Кассир {} завершил обслуживание клиента. Товаров: {}, Общая сумма: {}",
                cashierId, customerItems.length, totalCost);
    }
}
