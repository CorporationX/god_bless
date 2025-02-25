package school.faang.sprint4.bjs2_61902;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(@NonNull List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allFutures.thenRun(() -> System.out.println("Обработано заказов: " + totalProcessedOrders.get()))
                .join();
    }
}
