package school.faang.amazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int TIMEOUT_MS = 500;

    public CompletableFuture<Void> processOrder(Order order) {
        log.debug("Processing order {}", order);
        Objects.requireNonNull(order);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIMEOUT_MS);
            } catch (InterruptedException e) {
                log.error("Interrupted", e);
            }
            return order;
        }, ThreadPullProvider.executor).thenApply(currentOrder -> {
            currentOrder.updateStatus(OrderStatus.DONE);
            return currentOrder;
        }).thenRun(() -> totalProcessedOrders = new AtomicInteger(totalProcessedOrders.incrementAndGet()));
    }

    public void processAllOrders(List<Order> orders) {
        log.debug("Processing orders {}", orders);
        List<Void> list = orders.stream()
                .filter(Objects::nonNull)
                .map(this::processOrder)
                .map(CompletableFuture::join)
                .toList();
        System.out.println(totalProcessedOrders);
    }

}
