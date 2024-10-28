package amazonorders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int ORDER_PROCESSING_TIME_MS = 1000;

    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESSING_TIME_MS);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
            }
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }

    public int processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processOrderFutures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(processOrderFutures.toArray(new CompletableFuture[0])).join();
        return totalProcessedOrders.get();
    }
}