package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final Logger logger = LoggerFactory.getLogger(WeasleyFamily.class);
    private static final int TIMEOUT_SECONDS = 5;
    private final Chore[] chores;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public WeasleyFamily(Chore[] chores) {
        validateChores(chores);
        this.chores = chores;
    }

    public void completeTasks() {
        for (Chore task : chores) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                logger.info("Not all tasks had been completed in {} seconds.", TIMEOUT_SECONDS);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted while waiting for termination", e);
        }
    }

    private void validateChores(Chore[] chores) {
        if (chores == null || chores.length == 0) {
            throw new IllegalArgumentException("Chores can't be null or empty.");
        }
    }
}
