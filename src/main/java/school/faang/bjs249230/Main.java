package school.faang.bjs249230;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int GAME_LENGTH = 100;
    private static final int THREAD_POOL_SIZE = 10;
    private static final double EARNED_POINTS = 0.5;
    private static final double LOST_LIFE = 0.7;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        IntStream.range(0, GAME_LENGTH)
                .forEach(i -> executorService.submit(() -> {
                    boolean earnedPoints = Math.random() > EARNED_POINTS;
                    boolean lostLife = Math.random() > LOST_LIFE;

                    game.update(earnedPoints, lostLife);
                }));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
        }
    }
}