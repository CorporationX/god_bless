package school.faang.sprint3.bjs2_61654;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final int awaitTermination = 5;
        final String forceTerminationMessage = String.format(
                "Потоки не завершились за %d секунд, делаем принудительное завершение", awaitTermination);
        final String interruptedThreadMessage = "Работа потока прервана при завершении";

        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;
                game.update(earnedPoints, lostLife);
            });
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(awaitTermination, TimeUnit.SECONDS)) {
                log.debug(forceTerminationMessage);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(interruptedThreadMessage, e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
