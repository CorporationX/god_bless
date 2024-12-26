package school.faang.task_50715;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Inventory inventory = new Inventory(executorService);

        inventory.combineItemsAndAddToInventory();

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("All tasks completed successfully");
            } else {
                log.info("Tasks not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
