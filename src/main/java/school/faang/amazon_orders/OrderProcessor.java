package school.faang.amazon_orders;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long THREAD_SLEEP_TIME = 300L;
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
                order.setStatus(OrderStatus.PROCESSED);
                log.info("Order #{} {}", order.getId(), order.getStatus());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processedOrders = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(processedOrders.toArray(new CompletableFuture[0]))
                .join();
    }
}