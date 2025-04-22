package school.faang.bjs2_72950;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class WeasleyFamily {
    private static final Integer THREAD_POOL = 5;
    private List<String> chores;

    public void performChores() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
        for (String choreName : chores) {
            executor.execute(new Chore(choreName));
        }
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
            log.info("All tasks are completed.");
        } else {
            List<Runnable> notExecuted = executor.shutdownNow();
            log.info("{} tasks failed to start.", notExecuted.size());
        }
    }
}
