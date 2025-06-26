package school.faang.module4.amazon;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class OrderProcessor {
    private static final long ORDER_PROCESS_TIME_IN_MS = 3_000L;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processOrder(Order order) {
        synchronized (order) {
            if (Status.PROCESSED.equals(order.getStatus())) {
                System.out.printf("order #%d is already processed", order.getId());
                return;
            }
            System.out.printf("start processing order #%d\n", order.getId());
            try {
                Thread.sleep(ORDER_PROCESS_TIME_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            System.out.printf("end processing order #%d\n", order.getId());
        }
    }

    public void processAllOrders(@NonNull List<Order> orders) {
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("orders is empty");
        }
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        orders.stream()
                .forEach(order ->
                        completableFutures.add(
                                CompletableFuture.runAsync(() -> processOrder(order))
                        ));

        completableFutures.stream()
                .forEach(completableFuture -> completableFuture.join());
        System.out.printf("total processed orders = %d", totalProcessedOrders.get());
    }
}
