package school.faang.bjs273609;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_COUNT = 5;
    private static final int THREAD_TIMEOUT = 5;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 50;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        IntStream.range(MIN_RANGE, MAX_RANGE).forEach(i ->
                executor.submit(() -> {
                    while (!game.isGameOver()) {
                        boolean winner = Math.random() < 0.7;
                        boolean loose = Math.random() < 0.1;
                        game.update(winner, loose);
                    }
                }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Interrupted");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.print("Interrupted");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}