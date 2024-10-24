package school.faang.BJS2_38113_AmazonOrders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int PROCESSED_ORDERS_COUNT_DELTA = 1;
    private static final int MILLISECONDS_IN_SECOND = 1_000;
    private static final int MIN_ORDER_PROCESSING_TIME = 3;
    private static final int MAX_ORDER_PROCESSING_TIME = 7;

    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger();
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture.allOf(
                orders.stream()
                        .map(this::processOrder).toArray(CompletableFuture[]::new)
                )
                .thenRun(() -> log.info("All orders have been processed! Total count of processed orders: {}.", totalProcessedOrders.get()))
                .join();
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("The processing of order #{} has begun.", order.getId());
            try {
                int orderProcessingTime = ThreadLocalRandom.current().nextInt(MIN_ORDER_PROCESSING_TIME, MAX_ORDER_PROCESSING_TIME) * MILLISECONDS_IN_SECOND;
                Thread.sleep(orderProcessingTime);
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while order #{} processing",
                        Thread.currentThread().getName(), order.getId(),
                        e
                );
            }
            totalProcessedOrders.addAndGet(PROCESSED_ORDERS_COUNT_DELTA);
            order.setStatus(OrderStatus.PROCESSED);
            log.info("The processing of order #{} has ended.", order.getId());
        });
    }
}
