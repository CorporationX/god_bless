package school.faang.task_62130;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonOrderProcessing {
    private static final String TOTAL_ORDERS_MESSAGE = "Обработано заказов: {}";

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW.getStatus()),
                new Order(2, OrderStatus.NEW.getStatus()),
                new Order(3, OrderStatus.NEW.getStatus())
        );

        List<CompletableFuture<Order>> orderFutures = processor.processAllOrders(orders);

        CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[0]))
                .thenAccept(future -> log.info(TOTAL_ORDERS_MESSAGE, processor.getTotalProcessedOrders()))
                .join();
    }
}
