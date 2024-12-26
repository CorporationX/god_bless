package school.faang.sprint_3.task_49411;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final long AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {
        Game darkSouls = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                executor.submit(() -> {
                    while (darkSouls.getLives() > 0) {
                        darkSouls.update(darkSouls.earnedPoints(), darkSouls.lostLife());
                    }
                });
            }
            executor.shutdown();

            if (executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            log.error("Error message: ", e);
        }
    }
}
