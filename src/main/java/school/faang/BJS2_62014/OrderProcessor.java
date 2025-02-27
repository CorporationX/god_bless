package school.faang.BJS2_62014;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final long ORDERING_DELAY = 5000L;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private static void sleep() {
        try {
            Thread.sleep(ORDERING_DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task interrupted", e);
        }
    }

    public CompletableFuture<Order> processOrder(@NonNull Order order) {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.getAndIncrement();
            return order;
        });
    }

    public void processAllOrders(@NonNull List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

        allDone.thenAccept(v -> {
            long processed = futures.stream()
                    .map(CompletableFuture::join)
                    .filter(order -> order.getStatus().equals(OrderStatus.PROCESSED))
                    .count();

            String resultToPrint = processed != totalProcessedOrders.get() ? "Fault while processing!" :
                    "Orders processed: %d".formatted(totalProcessedOrders.get());
            System.out.println(resultToPrint);
        }).join();
    }
}
