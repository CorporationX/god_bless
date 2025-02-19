package school.faang.sprint.third.works;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final List<Chore> chores;

    public WeasleyFamily(@NonNull List<Chore> chores) {
        validateChores(chores);
        this.chores = chores;
    }

    public void doChores() {
        for (Chore chore : chores) {
            executor.submit(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                log.info("Some chores are still alive");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.info("Shutting down now executor");
            throw new RuntimeException(e);
        }
    }

    private void validateChores(List<Chore> chores) {
        if (chores.isEmpty()) {
            throw new IllegalArgumentException("Chores must have at least one chore");
        }
    }
}
