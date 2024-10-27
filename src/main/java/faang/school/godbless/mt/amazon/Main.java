package faang.school.godbless.mt.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Order.Status.CREATED),
                new Order(2, Order.Status.CREATED),
                new Order(3, Order.Status.CREATED)
        );

        List<CompletableFuture<Order>> futures = processor.processOrders(orders);
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        log.info("Processed orders = {}", processor.getProcessedOrdersCount());
    }
}
