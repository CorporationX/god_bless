package bjs2_74651;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int OPERATING_TIME = 5;
    private AtomicInteger totalPcocessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        CompletableFuture<Order> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(OPERATING_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalPcocessedOrders.incrementAndGet();
            return order;
        });
        return future;
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(order -> processOrder(order))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        orderProcessor.processAllOrders(orders);

        log.info("Total orders processed: {}", orderProcessor.totalPcocessedOrders.get());
    }
}
