package faang.school.godbless.collectingordersatamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class OrderCollector {
    private final OrderProcessor orderProcessor;
    private final List<Order> orders;

    public OrderCollector() {
        this.orderProcessor = new OrderProcessor();
        this.orders = getOrders();
    }

    public void collectOrders() {
        CompletableFuture<Void> future = CompletableFuture.allOf(orders.stream()
                .map(orderProcessor::processOrder)
                .toArray(CompletableFuture[]::new));
        future.join();
        orderProcessor.shutdown();
        log.info("Collected orders: {}", orderProcessor.getTotalProcessedOrders());
    }

    private static List<Order> getOrders() {
        return List.of(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5),
                new Order(6),
                new Order(7),
                new Order(8)
        );
    }
}