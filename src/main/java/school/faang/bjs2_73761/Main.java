package school.faang.bjs2_73761;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PLAYERS_COUNT = 2;
    private static final int TERMINATION_TIMEOUT = 10;
    private static final int LIVES_COUNT = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(PLAYERS_COUNT);

    public static void main(String[] args) {
        Game game = new Game(LIVES_COUNT);
        List<Future<?>> futures = new ArrayList<>();
        futures.add(
            executorService.submit(() -> {
                while (game.getLives() > 0) {
                    game.update(false, true);
                }
            })
        );
        futures.add(
            executorService.submit(() -> {
                while (game.getLives() > 0) {
                    game.update(true, false);
                }
            })
        );
        futures.add(
            executorService.submit(() -> {
                while (game.getLives() > 0) {
                    game.update(true, false);
                }
            })
        );
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Exception with message {} was thrown", e.getMessage());
                Thread.currentThread().interrupt();
            }
        });
        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}