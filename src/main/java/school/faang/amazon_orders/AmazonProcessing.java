package school.faang.amazon_orders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW),
                new Order(4, OrderStatus.NEW),
                new Order(5, OrderStatus.NEW),
                new Order(6, OrderStatus.NEW)
        );

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();
        futures.forEach(CompletableFuture::join);
        log.info(String.format("Количество обработанных заказов: %d.", OrderProcessor.getTotalProcessedOrders()));
    }
}
