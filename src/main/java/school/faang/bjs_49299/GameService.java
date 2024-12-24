package school.faang.bjs_49299;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GameService {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int AWAIT_TIMEOUT_SECONDS = 60;
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void gameStart() {
        List<Runnable> addScoreRunnable = List.of(
                () -> game.update(true, false),
                () -> game.update(false, true),
                () -> game.update(true, true),
                () -> game.update(false, false)
        );


        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        while (game.isRunning()) {
            addScoreRunnable.forEach(executorService::submit);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("GameService thread interrupted", e);
        }
    }
}
