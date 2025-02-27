package school.faang.sprint3.task_61683;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_TIMEOUT = 2;
    private static final int THREAD_SLEEP_TIMEOUT = 2;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            pool.submit(() -> game.update(earnedPoints, lostLife));

            try {
                Thread.sleep(THREAD_SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        pool.shutdown();

        try {
            if (!pool.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
