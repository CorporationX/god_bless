package school.faang.fan_calculations;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolProvider {
    private static final int TWENTY_SECONDS_IN_MS = 20_000;
    private static final int THREAD_NUM = Runtime.getRuntime().availableProcessors();

    public static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

    public static void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TWENTY_SECONDS_IN_MS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            executor.shutdownNow();
        }
    }

}
