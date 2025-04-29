package school.faang.bjs2_74880;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static school.faang.bjs2_74880.OrderStatus.NEW;

@Slf4j
public class AmazonOrderProcessing {
    private static final int NUM_THREADS = 6;
    private static final int MAX_EXPECTATION = 60;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);
        OrderProcessor processor = new OrderProcessor(poolThreads);

        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, NEW)
        );

        CompletableFuture<Order>[] processedAllOrders = processor.processAllOrders(orders);

        CompletableFuture<Void> allDone = CompletableFuture.allOf(processedAllOrders);
        allDone.join();

        log.info("Processed {} orders", processor.getTotalProcessedOrders());

        gracefullyShutdown(poolThreads);
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stoppage error");
            executorService.shutdownNow();
        }
    }
}
