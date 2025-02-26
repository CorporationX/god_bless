package school.faang.task61852;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < 20; i++) {
            executor.submit(() -> {
                boolean isScoreUpdated = Math.random() > 0.5;
                boolean isLivesLost = Math.random() > 0.5;
                game.update(isScoreUpdated, isLivesLost);
            });
        }
        executor.shutdown();
    }
}
