package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        List<Order> orders = (Arrays.asList(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5),
                new Order(6)
        ));
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Order>> futureOrders = orders.stream()
                .map(order -> processor.processOrder(order, executor))
                .toList();

        CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0])).join();
        log.info("{} order(s) have been processed.", processor.getTotalProcessedOrders().get());
        executor.shutdown();
    }
}
