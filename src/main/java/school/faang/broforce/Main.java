package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 4;
    private static final int INITIAL_LIVES = 5;
    private static final int TASK_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(INITIAL_LIVES);

        System.out.println("=== Start game state ===");
        log.info("Score = {}", game.getScore());
        log.info("Lives = {}\n", game.getLives());

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        Random rnd = new Random();

        for (int i = 0; i < TASK_COUNT; i++) {
            executor.submit(() -> {
                boolean scored = rnd.nextBoolean();
                game.update(scored);
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            log.info("Finishing executor...");
            executor.shutdownNow();
        }

        System.out.println();
        System.out.println("=== Final game state ===");
        log.info("Score = {}", game.getScore());
        log.info("Lives = {}", game.getLives());
    }
}
