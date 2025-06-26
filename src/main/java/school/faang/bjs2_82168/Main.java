package school.faang.bjs2_82168;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        OrderProcessor processor = new OrderProcessor(executor);

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый"),
                new Order(4, "Новый")
        );

        List<CompletableFuture<Void>> futureOrders = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture<Void> allOrders = CompletableFuture.allOf(
                futureOrders.toArray(new CompletableFuture[0])
        );
        allOrders.join();

        System.out.println("Обработано заказов: " + processor.getTotalProcessedOrders());

        executor.shutdown();
    }
}