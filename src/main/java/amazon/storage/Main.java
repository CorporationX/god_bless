package amazon.storage;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int ORDERS_COUNT = 100;

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        var orders = initOrders();
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Orders processed: " + orderProcessor.getTotalProcessedOrders());
        orderProcessor.shutdown();
    }

    private static List<Order> initOrders() {
        return IntStream.rangeClosed(1, ORDERS_COUNT)
                .mapToObj(i -> new Order())
                .toList();
    }
}
