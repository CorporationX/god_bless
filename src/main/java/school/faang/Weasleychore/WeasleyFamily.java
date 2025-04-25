package school.faang.Weasleychore;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final List<String> chores = List.of(
            "washing the dishes",
            "sweeping the floor",
            "cooking dinner",
            "doing the laundry"
    );

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            executor.submit(new Chore(task));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Not all tasks are completed on time. Forced shutdown");
                executor.shutdownNow();
                return;
            }
            log.info("All tasks completed");
        } catch (InterruptedException e) {
            log.warn("Waiting for task completion was interrupted");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}