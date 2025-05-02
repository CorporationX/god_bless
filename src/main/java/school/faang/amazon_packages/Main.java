package school.faang.amazon_packages;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import static school.faang.amazon_packages.OrderStatus.ORDERED;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, ORDERED),
                new Order(2, ORDERED),
                new Order(3, ORDERED)
        );

        List<CompletableFuture<Order>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();

        System.out.println("Обработано заказов: " + processor.getTotalProcessedOrders());
    }
}
