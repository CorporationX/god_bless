package school.faang.BJS2_61967;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Всего обработано заказов: {}", processor.getTotalProcessedOrders());
    }
}