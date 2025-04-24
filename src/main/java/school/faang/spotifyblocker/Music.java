package school.faang.spotifyblocker;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static int AVAILABLE_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(AVAILABLE_THREADS);
        Player player = new Player();

        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::skip);
        executor.execute(player::previous);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Executor didn't terminate within 5 seconds, terminating tasks immediately...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Thread was interrupted while waiting for executor to terminate.", e);
        }
    }
}
