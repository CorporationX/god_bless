package school.faang.bjs2_73272;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Player player = new Player();
        executorService.execute(player::play);
        executorService.execute(player::pause);
        executorService.execute(player::skip);
        executorService.execute(player::previous);
        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}