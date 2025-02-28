package school.faang.BJS2_64059;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(),
                new Order(),
                new Order(),
                new Order()
        );
        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Order>> result = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(result.toArray(new CompletableFuture[0]))
                .join();

        log.info("Обработано заказов: {}", orderProcessor.getTotalProcessedOrders());
    }
}
