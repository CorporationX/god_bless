package school.faang.utils;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadUtils {
    public static void gracefulShutdown(
            @NonNull ExecutorService executorService,
            int awaitShutdownMinutes,
            Runnable finalCallback) {
        executorService.shutdown();
        try {
            boolean allCompleted = executorService.awaitTermination(awaitShutdownMinutes, TimeUnit.MINUTES);
            if (allCompleted) {
                log.info("Executor shut down, no more tasks to process");
            } else {
                log.error("Some tasks could not finish before executor termination");
            }
            if (finalCallback != null) {
                finalCallback.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Waiting for executor termination interrupted");
            throw new RuntimeException(e);
        }
    }
}
