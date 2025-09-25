package school.faang.bjs2_93200;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(156461, OrderStatus.UNCONFIRMED),
                new Order(148161, OrderStatus.UNCONFIRMED),
                new Order(687164, OrderStatus.UNCONFIRMED),
                new Order(761561, OrderStatus.UNCONFIRMED),
                new Order(561894, OrderStatus.UNCONFIRMED),
                new Order(123156, OrderStatus.UNCONFIRMED)
        );

        List<CompletableFuture<Order>> allProcessedOrders = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();
        CompletableFuture.allOf(allProcessedOrders.toArray(new CompletableFuture[0]))
                .thenRun(orderProcessor::getTotalProcessedOrders);

        Thread.sleep(2000);
        orderProcessor.processOrder(orders.get(3));
        Thread.sleep(2000);
        orderProcessor.processOrder(orders.get(3));
        Thread.sleep(10000);
        orderProcessor.getTotalProcessedOrders();
        orderProcessor.shutdownCorrectly();
    }
}
