package faang.school.godbless.BJS2_13753;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static final int ORDERS_NUMBER = 1000;

    public static void main(String[] args) throws InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = IntStream.rangeClosed(1, ORDERS_NUMBER)
                .boxed()
                .map(id -> new Order(id, "New order"))
                .toList();

        List<CompletableFuture<Void>> completableFutureOrders = new ArrayList<>();
        for (Order order : orders) {
            completableFutureOrders.add(orderProcessor.processOrder(order));
        }

        OrderProcessor.EXECUTOR.shutdown();

        CompletableFuture<Void> ordersProcessingFuture = CompletableFuture.allOf(completableFutureOrders.toArray(new CompletableFuture[0]));
        ordersProcessingFuture.join();

        log.info("Orders processed: {}", orderProcessor.getTotalProcessedOrders().toString());
    }
}
