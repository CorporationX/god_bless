package faang.school.godbless.collectingordersamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = initialize();

        List<CompletableFuture<Void>> futureList = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        log.info("totalProcessedOrders {}", orderProcessor.getTotalProcessedOrders().get());
    }

    private static List<Order> initialize() {
        return List.of(
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order()
        );
    }
}
