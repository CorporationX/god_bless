package school.faang.amazon_assync;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private static final ExecutorService orderExecutor = Executors.newCachedThreadPool();
    private static final int FIVE_SECONDS_IN_MS = 5_000;
    private static final long MAX_WAIT_MINUTES = 1;

    static void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> ordersFuture = orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> {
                    processOrder(order);
                    return order;
                }, orderExecutor))
                .toList();
        CompletableFuture.allOf(ordersFuture.toArray(CompletableFuture[]::new)).join();
        System.out.println("Обработано заказов: " + totalProcessedOrders);
        shutdown();
    }

    private static void processOrder(Order order) {
        System.out.println("Обработка заказа № " + order.getId());
        try {
            Thread.sleep(FIVE_SECONDS_IN_MS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        order.setStatus(OrderStatus.PROCESSED);
        totalProcessedOrders.incrementAndGet();
        System.out.println("Заказ № " + order.getId() + " обработан");
    }

    public static void shutdown() {
        orderExecutor.shutdown();
        try {
            if (!orderExecutor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Not all tasks are completed in {} minutes. Attempting to force stop", MAX_WAIT_MINUTES);
                orderExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Waiting for threads to finish is interrupted.");
            orderExecutor.shutdownNow();
        }
    }
}