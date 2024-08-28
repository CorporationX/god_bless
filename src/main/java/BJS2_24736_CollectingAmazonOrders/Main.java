package BJS2_24736_CollectingAmazonOrders;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = Arrays.asList(new Order(1, "Processed"), new Order(2, "In progress"),
                new Order(3, "In progress"), new Order(4, "In Progres"));

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture<Void> futureResult = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Processed orders: {} from {}", orderProcessor.getTotalProcessedOrders(),
                        orders.size()));

        futureResult.join();
    }
}
