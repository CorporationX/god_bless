package school.faang.task_50031;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            order.setStatus("processed");
            totalProcessedOrders.incrementAndGet();
            return order;
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = new ArrayList<>();
        orders.forEach(o -> futures.add(processOrder(o)));
        futures.forEach(CompletableFuture::join);
        log.info("All orders processed: {}", totalProcessedOrders.get());
    }
}
