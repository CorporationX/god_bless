package school.faang.bjs2_90145;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long TIMEOUT_MS = 100L;
    private static final int TASK_COUNT = 100;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newCachedThreadPool();

        log.info("Начало игры Bro Force!");
        for (int i = 0; i < TASK_COUNT; i++) {
            final int taskNumber = i;
            executorService.submit(() -> {
                boolean earnedPoints = Math.random() < 0.5;
                boolean lostLife = Math.random() < 0.3;

                synchronized (game) {
                    game.update(earnedPoints, lostLife);
                }

                try {
                    Thread.sleep(TIMEOUT_MS);
                } catch (InterruptedException e) {
                    log.error("Игра прервана", e);
                    Thread.currentThread().interrupt();
                }
            });
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Игра не завершились вовремя, принудительное завершение");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения прервано", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Игра завершена!");
    }
}