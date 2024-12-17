package school.faang.sprint3.task49010.task49400;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MainApp {

    private static final int DELTA_TIME_MSEC = 100;
    public static void main(String[] args) {

        Game game = new Game();
        ExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.submit(() -> letsGame(game));
        executor.submit(() -> letsGame(game));
        executor.submit(() -> letsGame(game));
        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void letsGame(Game game) {
        boolean earnedPoints;
        boolean lostLife;
        do {
            earnedPoints = Math.random() > 0.5;
            lostLife = Math.random() > 0.5;
            game.update(earnedPoints, lostLife);
            try {
                sleep(DELTA_TIME_MSEC);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!game.isOver());
    }

}
