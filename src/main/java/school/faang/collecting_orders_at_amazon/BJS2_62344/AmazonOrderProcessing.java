package school.faang.collecting_orders_at_amazon.BJS2_62344;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(Status.NEW),
                new Order(Status.NEW),
                new Order(Status.NEW)
        );


        List<CompletableFuture<Void>> resultFutures = processor.processAllOrders(orders);
        CompletableFuture<Void> future = CompletableFuture.allOf(resultFutures.toArray(new CompletableFuture[0]));
        future.join();
        log.info("Количество обработанных заказов: {}", processor.getTotalProcessedOrders());
    }
}
