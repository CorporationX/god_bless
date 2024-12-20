package school.faang.sprint3.bjs_48179;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int TIME_OUT = 1000;

    public void runTasks(List<String> chores) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.MILLISECONDS)) {
                log.error("Thread can't be finished");
            } else {
                log.info("All tasks completed");
            }
        } catch (InterruptedException e) {
            log.error("Unexpected interruption");
        } finally {
            executor.shutdownNow();
        }
    }
}
