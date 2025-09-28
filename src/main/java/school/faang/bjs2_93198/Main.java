package school.faang.bjs2_93198;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        List<CompletableFuture<Integer>> processAllOrders = orders.stream()
                .map(order -> processor.processOrder(order)).toList();

        CompletableFuture<Void> completedFuture = CompletableFuture
                .allOf(processAllOrders.toArray(new CompletableFuture[0]));
        completedFuture.join();

        log.info("Orders have been processed");
    }
}