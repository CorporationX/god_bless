package school.faang.bjs50130;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public static final long PROCESSING_TIME = 5000;

    private final AtomicInteger totalProcessedCount;

    public OrderProcessor() {
        totalProcessedCount = new AtomicInteger(0);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> results = new ArrayList<>();
        orders.forEach(order -> results.add(processOrder(order)));
        results.forEach(CompletableFuture::join);
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(PROCESSING_TIME);
                    } catch (InterruptedException e) {
                        log.info("Error processing {}", e.getMessage());
                    }
                    order.setProcessed(true);
                    totalProcessedCount.incrementAndGet();
                    log.info("Order {} processed", order.getId());
                    return order;
                }
        );
    }

    public int getTotalProcessedCount() {
        return totalProcessedCount.get();
    }
}
