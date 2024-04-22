package faang.school.godbless.collect_orders_on_amazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger();
    }

    public CompletableFuture<Void> processOrder(Order order, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            log.info("Order with id = {} was processed", order.getId());
            totalProcessedOrders.addAndGet(1);
        }, executorService);
    }
}