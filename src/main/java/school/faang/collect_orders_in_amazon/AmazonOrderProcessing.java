package school.faang.collect_orders_in_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый"),
                new Order(4, "Новый"),
                new Order(5, "Новый"),
                new Order(6, "Новый")
        );

        CompletableFuture<Void> processingFuture = processor.processAllOrders(orders);

        processingFuture.thenRun(() -> log.info(
                "Финальный статус: {} заказов обработано", processor.getTotalProcessedOrders()));
        processingFuture.join();
    }
}
