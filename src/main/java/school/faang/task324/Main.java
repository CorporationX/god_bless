package school.faang.task324;

import school.faang.task324.game.Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final double CHANCE_TO_GET_SCORE_POINT = 0.4;
    private static final double CHANCE_TO_LOSE_LIVE_POINT = 0.84;
    private static int SLEEP_TIME = 500;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        boolean isScoreChanged = Math.random() > CHANCE_TO_GET_SCORE_POINT;
                        boolean isLivesChanged = Math.random() > CHANCE_TO_LOSE_LIVE_POINT;
                        game.update(isScoreChanged, isLivesChanged);
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e.getMessage());
                    }
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Что то пошло не так прерываем все нити");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }

    }
}
