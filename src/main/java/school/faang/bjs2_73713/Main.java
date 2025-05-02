package school.faang.bjs2_73713;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        boolean isWinning = Math.random() < 0.8;
        boolean isLosingHp = Math.random() < 0.7;
        IntStream.range(1, 100).forEach(i -> {
            executorService.execute(() -> {
                game.update(isWinning, isLosingHp);
            });
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted");
        }
    }
}

