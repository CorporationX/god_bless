package school.faang.task_49231;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 20; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            executor.submit(() -> game.update(earnedPoints, lostLife));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
