package school.faang.orders_amazon_BJS2_38059;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(Order order) {
        long processTime = 3000;
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        order.setStatus(OrderStatus.PROCESSED);
        totalProcessedOrders.incrementAndGet();
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() ->
                        processOrder(order), executor))
                .toList();
        executor.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Processed orders: " + totalProcessedOrders));
    }
}