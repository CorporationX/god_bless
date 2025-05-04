package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class Utils {
    public static void handleInterruptedException(InterruptedException e) {
        Thread.currentThread().interrupt();
        log.warn("Thread was interrupted! {}", e.getMessage());
    }

    public static void handleExecutionException(ExecutionException e) {
        log.warn("Execution failed! {}", e.getMessage());
        Throwable cause = e.getCause();
        if (cause != null) {
            log.warn("Caused by: {}", cause.getMessage());
        }
    }
}
