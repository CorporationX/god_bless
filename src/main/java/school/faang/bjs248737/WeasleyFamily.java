package school.faang.bjs248737;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    public final String[] chores;

    public WeasleyFamily(String[] chores) {
        if (chores == null || chores.length == 0) {
            log.warn("Chores array cannot be null or empty. Error in WeasleyFamily constructor.");
        }
        this.chores = chores;
    }

    public void executorChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        log.info("Thread pool was created");
        try {
            for (String task : chores) {
                try {
                    Chore chore = new Chore(task);
                    executorService.execute(chore);
                    log.info("Task '{}' was add into the Thread pool", task);
                } catch (IllegalArgumentException e) {
                    log.warn("Failed to add task '{}': {}", task, e.getMessage());
                }
            }
        } finally {
            executorService.shutdown();
            log.info("Shutdown of thread pool was initiated. No longer adding new tasks.");

            try {
                if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                    log.warn("Some tasks didn't finish whit 5 min. Force shutdown");
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("The Main thread was interrupted while waiting to task complete");
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            log.info("All tasks were completed and thread pool closed.");
        }
    }
}