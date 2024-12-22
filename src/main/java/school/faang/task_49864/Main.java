package school.faang.task_49864;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        MasterCardService masterCardService = new MasterCardService();

        masterCardService.doAll(executorService);

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Tasks completed successfully");
            } else {
                log.error("Tasks were not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
