package school.faang.walmart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@RequiredArgsConstructor
@Slf4j(topic = "CashierThread")
public class CashierThread extends Thread {

    private final String cashierId;
    private final CustomerItem[] customerItems;

    @Override
    public void run() {
        double totalCost = 0;
        for (var customerItem : customerItems) {
            log.info("Кассир {} обработал товар {}", cashierId, customerItem.name());
            totalCost += customerItem.cost();
        }
        log.info("Кассир {} завершил обработку товаров; Количество товаров {}; Общая стоимость: {}",
                cashierId, customerItems.length, totalCost);
    }
}
