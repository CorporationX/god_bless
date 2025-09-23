package school.faang.m3_2_synchronized.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.3;

            executorService.submit(() -> {
                while (game.getLives() > 0) {
                    game.update(earnedPoints, lostLife);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
