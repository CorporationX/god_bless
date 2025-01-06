package school.faang.sprint4.task_50229;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int SECONDS_TO_PROCESS_ORDER = 5;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.debug("Start to process {}", order);
            try {
                Thread.sleep(1000 * SECONDS_TO_PROCESS_ORDER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus(OrderStatus.PROCESSED);
            log.debug("Order {} has been put into status PROCESSED", order.getId());
            totalProcessedOrders.incrementAndGet();
            log.debug("Number of processed orders updated !");
        });
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<Void>[] ordersInProcess = orders.stream().map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(ordersInProcess)
                .thenRun(() -> log.info("Number of processed orders {}", totalProcessedOrders.get()))
                .join();
    }
}
