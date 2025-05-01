package school.faang.bjs2_74880;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.bjs2_74880.OrderStatus.PROCESSED;

@Slf4j
public class OrderProcessor {
    private static final int TIME_LAG = 10_000;
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService poolThreads;

    public OrderProcessor(ExecutorService poolThreads) {
        this.poolThreads = poolThreads;
    }

    @SuppressWarnings("unchecked")
    public CompletableFuture<Order>[] processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_LAG);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new ThreadStoppedException(ex);
            }
            order.setStatus(PROCESSED);
            totalProcessedOrders.incrementAndGet();
            log.info("Order with id {} processed", order.getId());
            return order;
        }, poolThreads);
    }
}
