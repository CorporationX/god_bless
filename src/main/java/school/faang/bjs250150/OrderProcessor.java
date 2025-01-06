package school.faang.bjs250150;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);
                order.setStatus(OrderStatus.PROCESSED);
                int total = totalProcessedOrders.incrementAndGet();
                log.info("Order {} processed. Total processed orders: {}", order.getId(), total);
            } catch (InterruptedException e) {
                log.error("Error processing order {}", order.getId(), e);
                Thread.currentThread().interrupt();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futureList = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allOf.join();
        log.info("Total processed orders: {}", totalProcessedOrders.get());

    }
}
