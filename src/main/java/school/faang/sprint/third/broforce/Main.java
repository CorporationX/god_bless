package school.faang.sprint.third.broforce;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_THREADS = 5;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
        for (int i = 0; i < 100; i++) {
            double random = RANDOM.nextDouble(1);
            boolean isScoreEarned = Math.round(random * 0.9) == 1;
            boolean isLiveLose = Math.round(random * 0.6) == 0;
            executorService.submit(() -> game.update(isScoreEarned, isLiveLose));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
