package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(new AtomicInteger(0));

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW.getStatus()),
                new Order(2, OrderStatus.NEW.getStatus()),
                new Order(3, OrderStatus.NEW.getStatus())
        );

        CompletableFuture[] futures = orders.stream().map(processor::processOrder).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.println(processor.getTotalProcessedOrders());
    }
}
