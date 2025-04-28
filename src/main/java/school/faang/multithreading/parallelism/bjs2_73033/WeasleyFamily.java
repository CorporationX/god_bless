package school.faang.multithreading.parallelism.bjs2_73033;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final String[] chores = {"wash the dishes", "cook the breakfast",
            "cook the dinner", "cook the supper", "vacuum the floor", "wash the floor"};
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void createChores() {
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Tasks are not finished. Force Termination.");
                executorService.shutdownNow();
            } else {
                log.info("Tasks are successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            executorService.shutdownNow();
        }

        log.info("Main thread finished.");
    }
}
