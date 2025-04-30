package school.faang.bjs2_74570;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private static final int SLEEP_TIME = 3;
    private static final int TIMEOUT = 10;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(SLEEP_TIME);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();

                return "Order with id - %d, now has status %s".formatted(order.getId(), order.getStatus());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage());
            }
            return "Order with id %d hasn't been processed successfully".formatted(order.getId());
        });

        return future.thenAccept(log::info);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> future = orders.stream().map(this::processOrder).toList();

        CompletableFuture<Void> completed = CompletableFuture.allOf(future.toArray(new CompletableFuture[0]));
        completed.thenAccept(v -> log.info("Completed {} orders", totalProcessedOrders))
                .orTimeout(TIMEOUT, TimeUnit.SECONDS)
                .join();
    }
}
