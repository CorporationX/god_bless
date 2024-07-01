package faang.school.godbless.sprint3.ordersInAmazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@AllArgsConstructor
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders;
    private final ExecutorService executorService;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000L);
                synchronized (order.getLock()) {
                    log.info("starting updating");
                    if (order.getStatus() == OrderStatus.CREATED) {
                        order.setStatus(OrderStatus.IN_PROCESS);
                        totalProcessedOrders.incrementAndGet();
                    }
                    log.info("updating has been completed");
                }
            } catch (InterruptedException e) {
                log.error("error message in thread \"{}\": {}", Thread.currentThread().getName(), e.getMessage());
            }
        }, executorService);
    }
}
