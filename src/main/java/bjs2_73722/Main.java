package bjs2_73722;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final double EARN_POINTS_PROBABILITY = 0.5;
    private static final double LOSE_LIFE_PROBABILITY = 0.5;
    private static final int TOTAL_NUM_UPDATES = 100;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < TOTAL_NUM_UPDATES; i++) {
            boolean changingScore = Math.random() > EARN_POINTS_PROBABILITY;
            boolean changingLives = Math.random() < LOSE_LIFE_PROBABILITY;

            executor.submit(() -> game.update(changingScore, changingLives));
        }
        executor.shutdown();
    }
}
