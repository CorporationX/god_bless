package school.faang.sprint.third.broforce;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            double random = rand.nextDouble(0, 1) * 10;
            int earnedScores = (int) Math.round(random);
            int loseLives = (int) Math.floor(random);
            executorService.submit(() -> game.update(earnedScores, loseLives));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
