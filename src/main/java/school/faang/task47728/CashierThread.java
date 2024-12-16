package school.faang.task47728;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
public class CashierThread extends Thread {

    private final int cashierId;
    private final Map<String, Integer> customerItems;

    @Override
    public void run() {
        if (customerItems == null) {
            throw new IllegalArgumentException("customerItems can`t be null");
        }

        log.info("Кассир {} принялся за работу%n", cashierId);
        int sum = customerItems.entrySet().stream().mapToInt(entry -> {
            log.info("Товар: {} Стоимость: {}", entry.getKey(), entry.getValue());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван во время ожидания: {}", e.getMessage());
                return 0;
            }
            return entry.getValue();
        }).sum();

        log.info("Кассир {} посчитал товары на такую сумму: {}", cashierId, sum);
    }
}
