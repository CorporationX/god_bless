package faang.school.godbless.BJS2_24684;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    static OrderProcessor orderProcessor = new OrderProcessor();

    public static void main(String[] args) {
        List<Order> orders = List.of(new Order(1, OrderStatus.NOT_PROCESSED),
                new Order(2, OrderStatus.NOT_PROCESSED),
                new Order(3, OrderStatus.NOT_PROCESSED),
                new Order(4, OrderStatus.NOT_PROCESSED),
                new Order(5, OrderStatus.NOT_PROCESSED));


        CompletableFuture<Void> combined = CompletableFuture.allOf(
                orders.stream()
                        .map(order -> CompletableFuture.runAsync(() -> processOrder(order)))
                        .toArray(CompletableFuture[]::new)
        );
        combined.join();
        System.out.println(orderProcessor.getTotalProcessedOrders());
    }

    private static void processOrder(Order order) {
        try {
            Thread.sleep(new Random().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        order.setStatus(OrderStatus.PROCESSED);
        orderProcessor.getTotalProcessedOrders().incrementAndGet();
    }
}
