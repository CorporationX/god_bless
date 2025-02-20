package school.faang.sprint3.task_BJS2_63777;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final int MAX_UPDATE_COUNT = 10;
    private static final double CHANCE_TO_EARN_POINTS = 0.5;
    private static final double CHANCE_TO_LOSE_LIFE = 0.7;
    private static final int DELAY_TO_STIMULATE_STEP = 100;

    public static void main(String[] args) {
        Game game = new Game();
        IntStream.range(0, MAX_UPDATE_COUNT).forEach(update ->  EXECUTOR.submit(() -> {
            boolean earnedPoints;
            boolean lostLife;

            while (!game.isGameOver()) {
                earnedPoints = Math.random() > CHANCE_TO_EARN_POINTS;
                lostLife = Math.random() > CHANCE_TO_LOSE_LIFE;
                game.update(earnedPoints, lostLife);

                try {
                    Thread.sleep(DELAY_TO_STIMULATE_STEP);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }));

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }
}
