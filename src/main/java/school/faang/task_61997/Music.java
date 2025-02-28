package school.faang.task_61997;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final long PLAYER_EXECUTOR_TIMEOUT_SECONDS = 3;
    public static final int THREADS = 4;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService playerExecutor = Executors.newFixedThreadPool(THREADS);

        List<Runnable> commands = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous,
                player::skip,
                player::play,
                player::pause,
                player::previous,
                player::play,
                player::skip,
                player::play,
                player::pause,
                player::skip,
                player::previous,
                player::skip,
                player::play,
                player::pause,
                player::previous);

        commands.forEach(playerExecutor::submit);

        playerExecutor.shutdown();

        try {
            if (!playerExecutor.awaitTermination(PLAYER_EXECUTOR_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.info("PlayerExecutor did not terminate within the timeout period.");
                playerExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error waiting for playerExecutor to terminate", e);
            Thread.currentThread().interrupt();
        }

        log.info("Done!");
    }
}
