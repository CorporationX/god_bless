package school.faang.amazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final String MESSAGE_READY_ORDER = "Ready";
    private static final int MAX_EXECUTE_TIME = 3000;
    private static final int MIN_EXECUTE_TIME = 1000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private void processOrder(Order order) {
        try {
            Thread.sleep((long) (Math.random() * MAX_EXECUTE_TIME + MIN_EXECUTE_TIME));
        } catch (InterruptedException e) {
            log.error("Execution order failed. Exception: {}\nStackTrace: {}", e, e.getStackTrace());
        }
        order.setStatus(MESSAGE_READY_ORDER);
        totalProcessedOrders.incrementAndGet();
        log.info("Order №{} processed", order.getId());
    }

    public void processAllOrders(List<Order> orders) {
        Objects.requireNonNull(orders, "Invalid list value");
        List<CompletableFuture<Void>> futureOrders = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order)))
                .toList();
        CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0])).join();
        log.info("Total processed orders: {}", totalProcessedOrders.get());
    }
}
