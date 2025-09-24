package school.faang.bjs2_93188;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final int SLEEP_COUNT = 1000;

    public Order processOrder(Order order) {
        try {
            Thread.sleep(SLEEP_COUNT);
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            log.info("order processed");
            return order;
        } catch (InterruptedException e) {
            log.error("Error{}", String.valueOf(e));
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> processOrder(order)))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.printf("Total processed orders: %s", totalProcessedOrders.get()))
                .join();
    }
}
