package school.faang.bjs2_93197;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AmazonOrderProcessing {
    private static final int COUNT_THREADS = 4;
    private static final int AWAIT_TERMINATED_MIN = 1;

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatuses.NEW),
                new Order(2, OrderStatuses.NEW),
                new Order(3, OrderStatuses.NEW)
        );

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() ->
                        orderProcessor.processOrder(order), executor))
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join();

        log.info("Обработано заказов: {}", orderProcessor.getTotalProcessedOrders());

        shutdown(executor);
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATED_MIN, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
