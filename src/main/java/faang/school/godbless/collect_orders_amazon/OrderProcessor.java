package faang.school.godbless.collect_orders_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final long PROCESSION_TIME_LOWER_BOUND = 1000L;
    private final long PROCESSION_TIME_UPPER_BOUND = 4000L;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            order.setStatus("Processing");
            log.info(order.getId() + " is being processed");
            long processionTime = ThreadLocalRandom.current().nextLong(
                    PROCESSION_TIME_LOWER_BOUND,
                    PROCESSION_TIME_UPPER_BOUND);

            try {
                Thread.sleep(processionTime);
            } catch (InterruptedException e) {
                order.setStatus("Confiscated");
                throw new RuntimeException("Found some illegal items in order: " + e.getMessage());
            }

            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            log.info(order.getId() + " was processed");
        });
    }

    public void showTotalProcessedOrdersNumber() {
        System.out.println("Total processed order number is: " + totalProcessedOrders.get());
    }
}