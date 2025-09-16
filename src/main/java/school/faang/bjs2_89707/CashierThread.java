package school.faang.bjs2_89707;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Slf4j
public class CashierThread extends Thread {
    private static final int PRICE_FOR_ONE_PRODUCT = 15;
    private static final int TIME_PROCESSING_ITEM = 1000;
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        log.info("the cashier {} began serving", cashierId);

        int totalPrice = 0;
        int totalItems = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * PRICE_FOR_ONE_PRODUCT;
            try {
                Thread.sleep(TIME_PROCESSING_ITEM);
                log.info("the cashier {} processed the goods", cashierId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("the cashier {} interrupted the service", cashierId, e);
            }
        }
        log.info("the cashier {} has finished serving the customer! Price - {}! Total items - {}",
                 cashierId, totalPrice, totalItems);

    }
}
