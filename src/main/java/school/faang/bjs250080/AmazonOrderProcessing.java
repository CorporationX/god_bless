package school.faang.bjs250080;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AmazonOrderProcessing {
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.AT_WORK),
                new Order(3, Status.NEW),
                new Order(4, Status.CANCELED)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(orders.size());

        OrderProcessor orderProcessor = new OrderProcessor(executorService);

        orderProcessor.processAllOrders(orders);

        log.info("Total orders processed: {}", orderProcessor.getTotalProcessedOrders());

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
        }
    }
}