package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPullSupplier {
    private static final int TIMEOUT_SECONDS = 10;
    private static final int THREAD_NUM = 3;

    public static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

    public static void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            executor.shutdownNow();
        }
    }
}
