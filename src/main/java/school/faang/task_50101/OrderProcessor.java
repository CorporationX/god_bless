package school.faang.task_50101;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final AtomicInteger totalCanceledOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                if (order.getStatus() == OrderStatus.CANCELED) {
                    totalCanceledOrders.incrementAndGet();
                    return;
                }

                Thread.sleep(2000);

                order.setStatus(OrderStatus.PROCESSED);

                totalProcessedOrders.incrementAndGet();

            } catch (InterruptedException e) {
                order.setStatus(OrderStatus.CANCELED);
                totalCanceledOrders.incrementAndGet();

                Thread.currentThread().interrupt();
            } catch (Exception e) {
                order.setStatus(OrderStatus.CANCELED);
                totalCanceledOrders.incrementAndGet();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Orders processed: " + totalProcessedOrders.get());
        System.out.println("Cancelled orders: " + totalCanceledOrders.get());
    }
}