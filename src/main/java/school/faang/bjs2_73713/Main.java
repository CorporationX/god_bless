package school.faang.bjs2_73713;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newCachedThreadPool();
        boolean isWinning = Math.random() < 0.9;
        boolean isLosingHp = Math.random() < 0.3;
        executorService.execute(() -> {
            IntStream.range(1, 100).forEach(i -> {
                game.update(isWinning, isLosingHp);
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Interrupted");
                }
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
        });
    }
}
