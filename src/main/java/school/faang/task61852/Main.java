package school.faang.task61852;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 5;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < 20; i++) {
            executor.submit(() -> {
                boolean isScoreUpdated = Math.random() > 0.5;
                boolean isLivesLost = Math.random() > 0.5;
                game.update(isScoreUpdated, isLivesLost);
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.error("Задачи не завершились за указанное время ({} сек.).", TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Принудительное завершение...");
            executor.shutdownNow();
        }
    }
}
