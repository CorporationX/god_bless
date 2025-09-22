package school.faang.bjs2_90102;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_THREAD = 2;
    private static final int AWAIT_TERMINATION_MIN = 1;
    private static final int THREAD_SLEEP_MILLIS = 100;
    private static final double PERCENT_ADD_SCORE = 0.5;
    private static final double PERCENT_LOST_LIVES = 0.3;
    private static final int COUNT_AVAILABLE_LIVES = 0;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

        try {
            while (game.getLivesCount() > COUNT_AVAILABLE_LIVES) {
                boolean isPointEarned = Math.random() < PERCENT_ADD_SCORE;
                boolean isLifeLost = Math.random() < PERCENT_LOST_LIVES;

                executor.submit(() -> game.update(isPointEarned, isLifeLost));

                try {
                    Thread.sleep(THREAD_SLEEP_MILLIS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(AWAIT_TERMINATION_MIN, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                executor.shutdownNow();
            }
        }
    }
}
