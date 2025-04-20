package school.faang.bjs272938;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class WeasleyFamily {
    private List<Chore> chores;

    public void doAllChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }

        executorService.shutdown();

        try {
            boolean isFinished = executorService.awaitTermination(5, TimeUnit.SECONDS);
            if (!isFinished) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Threads interruption: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}
