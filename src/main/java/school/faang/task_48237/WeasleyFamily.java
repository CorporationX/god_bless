package school.faang.task_48237;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final List<Chore> chores;

    public WeasleyFamily() {
        this.chores = new ArrayList<>();
    }

    public void addChore(@NonNull Chore chore) {
        chores.add(chore);
    }

    public void doAllChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(executor::execute);
        executor.shutdown();

        try {
            final int timeout = 1;
            boolean done = executor.awaitTermination(timeout, TimeUnit.SECONDS);
            if (done) {
                log.info("All threads have completed successfully");
            } else {
                log.warn("Not all threads have completed within the expected timeframe");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
