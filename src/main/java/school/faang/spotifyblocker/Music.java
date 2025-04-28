package school.faang.spotifyblocker;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static int AVAILABLE_THREADS = 5;

    public static void main(String[] args) {
        Player player = new Player();

        List<Runnable> toRun = new ArrayList<>(List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        ));

        ExecutorService executor = Executors.newFixedThreadPool(AVAILABLE_THREADS);

        toRun.forEach(executor::execute);

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
