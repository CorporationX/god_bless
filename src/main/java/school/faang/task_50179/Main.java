package school.faang.task_50179;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        List<CompletableFuture<Void>> processAllOrders = orders.stream()
                .map(processor::processOrder).toList();

        CompletableFuture<Void> AllOrders = CompletableFuture.allOf(processAllOrders.toArray(new CompletableFuture[0]));
        AllOrders.join();

        System.out.println("Обработано заказов: " + OrderProcessor.getTotalProcessedOrders());
    }
}
