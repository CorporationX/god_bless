package school.faang.bjs2_73013;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class WeasleyFamily {
    private final List<Chore> chores;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void executeChores() {
        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Во время выполнения возникло исключение: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}