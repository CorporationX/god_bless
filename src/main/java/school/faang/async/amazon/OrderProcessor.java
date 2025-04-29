package school.faang.async.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private static final long ORDER_PROCESS_TIME_MS = 10000L;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futureOrederList = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture
                .allOf(futureOrederList.toArray(new CompletableFuture[0]))
                .join();

        log.info("Amount of orders processed: {}", orders.size());
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Starting processing order {} with status {}", order.getId(), order.getStatus().name());
                Thread.sleep(ORDER_PROCESS_TIME_MS);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.addAndGet(1);
                log.info("Order {} was processed", order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });

    }
}
