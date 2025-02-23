package school.faang.blockingspotify;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final Player PLAYER = new Player();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_EXECUTION_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            List<Runnable> playTasks = List.of(
                    () -> executeTask(PLAYER::play),
                    () -> executeTask(PLAYER::pause),
                    () -> executeTask(PLAYER::skip),
                    () -> executeTask(PLAYER::previous)
            );
            playTasks.forEach(EXECUTOR::submit);
            EXECUTOR.shutdown();
            boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_EXECUTION_UNIT);
            if (isTerminated) {
                log.info("All done");
            } else {
                log.warn("Execution timed out: {} {}", TIME_EXECUTION, TIME_EXECUTION_UNIT);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException exception) {
            handleInterruptedException(exception);
        }
    }

    private static void executeTask(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            handleInterruptedException(exception);
        }
    }

    private static void handleInterruptedException(InterruptedException exception) {
        log.error("Thread interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                Thread.currentThread().getName(), exception, exception.getStackTrace());
        Thread.currentThread().interrupt();
        EXECUTOR.shutdownNow();
    }
}
