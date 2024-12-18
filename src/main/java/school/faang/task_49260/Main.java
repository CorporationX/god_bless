package school.faang.task_49260;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int CORE_POOL_SIZE = 4;

    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 100;
    private static final TimeUnit UNIT_OF_TIME = TimeUnit.MILLISECONDS;

    public static void main(String[] args) {
        Game game = new Game();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            if (!game.isGameOver()) {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;
                game.update(earnedPoints, lostLife);
            } else  {
                executor.shutdown();
            }
        }, INITIAL_DELAY, PERIOD, UNIT_OF_TIME);

        try {
            final int timeout = 10;
            final boolean isTaskCompleted = executor.awaitTermination(timeout, TimeUnit.SECONDS);
            if (isTaskCompleted) {
                log.info("Task completed successfully!");
            } else  {
                log.warn("Task not completed within the specified time limit.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
