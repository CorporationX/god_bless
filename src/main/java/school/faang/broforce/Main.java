package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREADS = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREADS);

    public static void main(String[] args) {

        Game game = new Game();

        for (int i = 0; i < THREADS; i++) {

            EXECUTOR.submit(() -> {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;
                game.update(earnedPoints, lostLife);

            });
            sleep();
        }

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(10, TimeUnit.MICROSECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("поток был прирван");
        } finally {
            EXECUTOR.shutdownNow();
        }
    }

    public static void sleep() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}