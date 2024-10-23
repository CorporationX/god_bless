package school.faang.sprint_4.bjs2_38283_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class OrderProcessor {
    private static final int THREADS_COUNT = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> orders.add(new Order()));
        orderProcessor.processAllOrders(orders);
    }

    private Order processOrder(Order order) {
        try {
            log.info("Start processing of order #'{}'.", order.getId());
            Thread.sleep(2000);
            order.setStatus(Status.DONE);
            log.info("Order #'{}' processed successfully. New status: {}", order.getId(), order.getStatus());
            totalProcessedOrders.incrementAndGet();
        } catch (InterruptedException e) {
            log.error("An error occurred while order processing.", e);
            throw new IllegalStateException(e);
        }
        return order;
    }

    private void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futureOrders = orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> processOrder(order), executor))
                .toList();

        CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("All orders processed! Total count: '{}'.", totalProcessedOrders.get()));
        finishProcessing();
    }

    private void finishProcessing() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down now!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}
