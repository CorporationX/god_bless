package school.faang.task47728;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class CashierThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(CashierThread.class);

    private final int cashierId;
    private final Map<String, Integer> customerItems;

    @Override
    public void run() {
        if (customerItems == null) {
            throw new IllegalArgumentException("customerItems can`t be null");
        }

        System.out.printf("Кассир %d принялся за работу%n", cashierId);
        int sum = customerItems.entrySet().stream().mapToInt(entry -> {
            System.out.printf("Товар: %s Стоимость: %s%n", entry.getKey(), entry.getValue());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                return 0;
            }
            return entry.getValue();
        }).sum();

        System.out.printf("Кассир %d посчитал товары на такую сумму: %d%n", cashierId, sum);
    }
}
