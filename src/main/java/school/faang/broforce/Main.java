package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int LAYERS_COUNT = 3;
    private static final int ROUNDS_COUNT = 50;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(LAYERS_COUNT);

        for (int round = 0; round < ROUNDS_COUNT; round++) {
            executor.submit(() -> {
                boolean playerScored = Math.random() < 0.5;
                boolean playerLostLife = Math.random() < 0.5;
                game.update(playerScored, playerLostLife);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
