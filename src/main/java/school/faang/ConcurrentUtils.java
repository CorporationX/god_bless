package school.faang;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

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
                    log.error("Thread interrupted", e.getCause());
                    break;
                }
            }
        }
    }

    public static <T> T tryLockAndDo(Lock lock, Callable<T> action) {
        while (true) {
            if (lock.tryLock()) {
                try {
                    return action.call();
                } catch (Exception e) {
                    log.error(e.getCause().getMessage());
                } finally {
                    lock.unlock();
                }
            } else {
                try {
                    Thread.sleep(LOCK_WAIT_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread interrupted", e.getCause());
                }
            }
        }
    }

    public static void shutdownExecutor(ExecutorService executor, int awaitTerminationTime, TimeUnit timeUnit) {
        shutdown(executor, awaitTerminationTime, timeUnit);
    }

    public static void shutdownExecutor(ExecutorService executor) {
        shutdown(executor, MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS);
    }

    private static void shutdown(ExecutorService executor, int awaitTerminationTime, TimeUnit timeUnit) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(awaitTerminationTime, timeUnit)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
