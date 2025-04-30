package school.faang.magicians;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolProvider {
    private static final int TEN_SECONDS_IN_MS = 10_000;

    public static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TEN_SECONDS_IN_MS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            executor.shutdownNow();
        }
    }

}
