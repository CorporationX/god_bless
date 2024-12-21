package school.faang.sprint_3.task_bjs249291;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int START_LIVES = 1000;
    private static final int GAME_TIME_SECONDS = 10;
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {
        Game game = new Game(START_LIVES);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        executorService.execute(() -> {
            while (!game.isGameOver()) {
                game.update();
            }
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(GAME_TIME_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
