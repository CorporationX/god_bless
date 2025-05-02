package school.faang.stream4.collectamazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long ORDER_PROCESSING_TIME_MS = 2000L;

    private final ExecutorService service;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public OrderProcessor(ExecutorService workers) {
        this.service = workers;
    }

    private CompletableFuture<Order> processOrder(Order order) {

        return CompletableFuture.supplyAsync(() -> {
            log.info("Start processing order #{}", order.getId());
            makeDelay(ORDER_PROCESSING_TIME_MS);
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
            log.info("Processing order #{} is finished and counted", order.getId());

            return order;
        }, service);
    }

    public void processAllOrders(List<Order> orders) {

        var futureOrders = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0]))
                .thenAcceptAsync(o -> log.info("Number of processed orders is {}", totalProcessedOrders), service)
                .join();
    }

    private static void makeDelay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("interrupted exception during delay: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void endProcess() {
        log.info("Processing is over!");
        int timeout = 30;
        service.shutdown();
        try {
            if (!service.awaitTermination(timeout, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
