package school.faang.bjs2_73916;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_COUNT = 5;
    public static final int AWAITING_TIME = 2;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            executorService.execute(new GameRunner(game));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                log.info("Timeout: game was not over within the allotted time");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for the game to end", e);
        }
    }
}
