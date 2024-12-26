package school.faang.bjs249590;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final double RANDOM_BALANCE = 0.5;
    private static final int ITERATION = 15;
    private static final int SLEEP = 100;
    private static final long LIVES = 10L;
    private static final long SCORE = 10L;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(LIVES, SCORE);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < ITERATION; i++) {
            executorService.submit(() -> {
                game.update(getRandomBoolean(), getRandomBoolean());
                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            });
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }

    private static boolean getRandomBoolean() {
        return Math.random() > RANDOM_BALANCE;
    }
}
