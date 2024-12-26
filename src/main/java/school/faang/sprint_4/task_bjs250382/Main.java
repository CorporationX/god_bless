package school.faang.sprint_4.task_bjs250382;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ORDERS = 10;
    private static final int EXECUTOR_NUMBER_OF_THREADS = 3;
    private static final long EXECUTOR_AWAIT_TERMINATION = 20L;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(EXECUTOR_NUMBER_OF_THREADS);
        OrderProcessor processor = new OrderProcessor(executor);
        List<Order> orders = TestDataGenerator.getTestOrders(NUMBER_OF_ORDERS);

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        log.info("Total orders processed: {}", processor.getTotalProcessedOrders().get());
        executor.shutdown();

        try {
            if (!executor.awaitTermination(EXECUTOR_AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Executor didn't stop correctly, shutdownNow");
                executor.shutdownNow();
            } else {
                log.info("Executor stopped correctly");
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
