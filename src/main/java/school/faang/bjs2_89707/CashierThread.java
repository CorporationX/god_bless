package school.faang.bjs2_89707;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
@Slf4j
public class CashierThread extends Thread {
    private static final int PRICE_FOR_ONE_PRODUCT = 15;
    private static final int TIME_PROCESSING_ITEM = 1000;
    private final int cashierId;
    private List<Integer[]> customerItems = new ArrayList<>();

    public CashierThread(int cashierId) {
        this.cashierId = cashierId;
    }

    public void addCustomer(Integer[] basket) {
        customerItems.add(basket);
    }

    @Override
    public void run() {
        log.info("the cashier {} began serving", cashierId);

        AtomicInteger totalPrice = new AtomicInteger();
        AtomicInteger totalItems = new AtomicInteger();
        customerItems.forEach(customer -> {
            Arrays.stream(customer).forEach(item -> {
                totalItems.getAndIncrement();
                totalPrice.addAndGet(item * PRICE_FOR_ONE_PRODUCT);
                try {
                    Thread.sleep(TIME_PROCESSING_ITEM);
                    log.info("the cashier {} processed the goods", cashierId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("the cashier {} interrupted the service", cashierId, e);
                }
            });
        });

        log.info("the cashier {} has finished serving the customer! Price - {}! Total items - {}",
                cashierId, totalPrice, totalItems);

    }
}
