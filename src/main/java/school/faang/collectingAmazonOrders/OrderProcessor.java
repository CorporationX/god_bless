package school.faang.collectingAmazonOrders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3_000);
                order.setStatus(Statuses.READY);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .filter(Order::checkIfOrdered)
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("All orders are processed."))
                .join();
    }

    public int getTotalProcessedOrdersInt() {
        return totalProcessedOrders.get();
    }
}
