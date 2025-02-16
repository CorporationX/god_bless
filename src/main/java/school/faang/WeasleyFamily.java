package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final Logger logger = LoggerFactory.getLogger(WeasleyFamily.class);
    private static final int TIMEOUT = 5;
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
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                logger.info("Not all tasks had been completed in {} seconds.", TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateChores(Chore[] chores) {
        if (chores == null) {
            throw new IllegalArgumentException("Chores can't be null.");
        }
    }
}
