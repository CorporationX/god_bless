package school.faang.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolProvider {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int THREAD_NUM = 10;

    public static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

    public static void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            executor.shutdownNow();
        }
    }
}
