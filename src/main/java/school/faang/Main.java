package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 4;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Game game = new Game(10);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.8;
                game.update(earnedPoints, lostLife);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    logger.error("Sleep was interrupted.");
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                logger.warn("Not all tasks have been completed on time");
                executor.shutdownNow();
            } else {
                logger.info("Game updates completed.");
            }
        } catch (InterruptedException e) {
            logger.error("Executor termination interrupted.");
        }
    }
}