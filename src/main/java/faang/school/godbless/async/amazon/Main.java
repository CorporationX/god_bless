package faang.school.godbless.async.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        var orderProcessor = new OrderProcessor();
        var orders = List.of(
                new Order(1L, "NEW"),
                new Order(2L, "NEW"),
                new Order(3L, "NEW"),
                new Order(4L, "NEW"),
                new Order(5L, "NEW"),
                new Order(6L, "NEW"),
                new Order(7L, "NEW")
        );

        var futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        var allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        log.info("Total orders completed: {}", orderProcessor.getTotalProcessedOrders());
    }
}
