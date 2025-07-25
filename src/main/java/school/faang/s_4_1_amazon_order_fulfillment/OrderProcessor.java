package school.faang.s_4_1_amazon_order_fulfillment;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public void showTotalProcessedOrders() {
        System.out.println("Total processed orders: " + totalProcessedOrders);
    }

    public CompletableFuture<Void> processOrders(List<Order> orders) {
        List<CompletableFuture<Order>> ordersFuture = orders.stream()
                .map(this::processOrder)
                .toList();
        return CompletableFuture.allOf(ordersFuture.toArray(new CompletableFuture[0]));
    }

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing order " + order.getId());
            order.setStatus(Status.PROCESSING);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.DONE);
            totalProcessedOrders.addAndGet(1);
            return order;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
