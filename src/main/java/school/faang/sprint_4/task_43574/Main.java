package school.faang.sprint_4.task_43574;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(Status.NEW),
                new Order(Status.NEW),
                new Order(Status.NEW)
        );

        List<CompletableFuture<Void>> futures = orders
                .stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Всего обработано заказов: " + orderProcessor.getTotalProcessedOrders().get());
    }
}
