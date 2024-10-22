package school.faang.m1s4.bjs2_38053_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int SLEEP_TIME = 5_000;
    private static final int TIMEOUT_SECONDS = 30;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService poolService = Executors.newFixedThreadPool(3);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        orders.forEach(order ->
                futures.add(CompletableFuture.runAsync(() -> processOrder(order), poolService)));

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allDone.thenRun(() -> System.out.println("Orders processed: " + totalProcessedOrders));
        shutdownPool();
    }

    private void processOrder(Order order) {
        sleepThread();
        order.setStatus("Done");
        totalProcessedOrders.getAndIncrement();
        System.out.printf("Order #%d processed. Status: %s%n", order.getId(), order.getStatus());
    }

    private void sleepThread() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }

    private void shutdownPool() {
        poolService.shutdown();
        try {
            if (!poolService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                poolService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
