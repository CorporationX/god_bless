package faang.school.godbless.orders_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
                order.setStatus("Processed");
                totalProcessedOrders.incrementAndGet();
                log.info("Product id:" + order.getId() + " in process");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Order processing interrupted: " + order);
            }
        });
    }

    public AtomicInteger getTotalProcessedOrders() {
        return totalProcessedOrders;
    }
}

