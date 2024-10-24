package org.example.service.countAmazonOrders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.countAmazonOrders.Order;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@NoArgsConstructor
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Order> processOrder(Order order) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
                return order;
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            log.info("Order: {} successfully processed", order.getId());
            executorService.shutdown();
            return order;
        }, executorService);
    }
}
