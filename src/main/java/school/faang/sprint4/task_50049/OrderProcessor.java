package school.faang.sprint4.task_50049;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int ORDER_PROCESSING_MAX_TIME = 10000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Random random = new Random();
                int sleepingTime = (int) (random.nextDouble() * ORDER_PROCESSING_MAX_TIME);
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (order.process()) {
                totalProcessedOrders.incrementAndGet();
                log.info("{} order is processed", order.getId());
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> ordersFuture = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> future = CompletableFuture.allOf(ordersFuture.toArray(new CompletableFuture[0]));
        future.join();

        log.info("All {} orders are processed", totalProcessedOrders.get());
    }
}
