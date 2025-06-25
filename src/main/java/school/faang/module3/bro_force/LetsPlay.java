package school.faang.module3.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LetsPlay {
    private static final int GAME_ITERATION = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Game game = new Game();
        for (int i = 0; i < GAME_ITERATION; i++) {
            boolean isScoreGain = i % 3 != 0;
            boolean isLiveLoss = i % 3 == 0;
            executor.execute(() -> game.update(isScoreGain, isLiveLoss));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("the game's still not over. force stopping...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            executor.shutdownNow();
        }
    }
}
