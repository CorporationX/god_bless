package school.faang;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "ConcurrentUtils")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConcurrentUtils {

    private static final int LOCK_WAIT_TIME = 1;
    private static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 2;

    public static void tryLockAndDo(Lock lock, Runnable action) {
        boolean success = false;
        while (!success) {
            if (lock.tryLock()) {
                try {
                    action.run();
                    success = true;
                } finally {
                    lock.unlock();
                }
            } else {
                try {
                    Thread.sleep(LOCK_WAIT_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread interrupted", e);
                    break;
                }
            }
        }
    }

    public static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
