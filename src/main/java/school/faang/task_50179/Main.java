package school.faang.task_50179;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        List<CompletableFuture<Void>> processAllOrders = orders.stream()
                .map(processor::processOrder).toList();

        CompletableFuture<Void> allOrders = CompletableFuture.allOf(processAllOrders.toArray(new CompletableFuture[0]));
        allOrders.join();

        log.info("Обработано заказов: {}", OrderProcessor.getTotalProcessedOrders());
    }
}
