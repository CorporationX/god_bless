package school.faang.BJS2_62033;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        OrderProcessor op = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(op::processOrder)
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(op.getTotalProcessorOrders());
    }
}
