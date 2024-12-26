package school.faang.task_50038;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        OrderProcessor processor = new OrderProcessor(executorService);

        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        processor.processAllOrders(orders);

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                log.warn("The tasks were not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error while shutting down ExecutorService: {}", e.getMessage());
        }
    }
}
