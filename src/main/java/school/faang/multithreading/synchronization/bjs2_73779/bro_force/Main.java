package school.faang.multithreading.synchronization.bjs2_73779.bro_force;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long DURATION = 70;
    private static final int AMOUNT_OF_THREADS = 5;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            executorService.submit(new Thread(() -> Main.doUpdates(game)));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Force Termination.");
                executorService.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            executorService.shutdownNow();
        }
        log.info("score = {}, lives = {}", game.getScore(), game.getLives());
    }

    private static void doUpdates(Game game) {
        Random rand = new Random();
        long start = System.currentTimeMillis();
        while (game.isRunning() && System.currentTimeMillis() - start < DURATION) {
            long newPoint = rand.nextLong(150);
            int lostLives = rand.nextInt(2);
            game.update(newPoint, lostLives);
        }
    }
}
