package school.faang.thebigbangtheory;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final List<Task> TASK_LIST = List.of(
            new Task("Sheldon", "theory preparation"),
            new Task("Leonard", "experiment modeling"),
            new Task("Howard", "tools developing"),
            new Task("Rajesh", "data analysing")
    );
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_EXECUTION_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            Objects.requireNonNull(EXECUTOR, "Executor is not initialized");
            Objects.requireNonNull(TASK_LIST, "Task list is not initialized");
            TASK_LIST.forEach(EXECUTOR::submit);
            EXECUTOR.shutdown();
            boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_EXECUTION_UNIT);
            if (isTerminated) {
                log.info("All tasks completed");
            } else {
                log.warn("Tasks has not completed within {} {}", TIME_EXECUTION, TIME_EXECUTION_UNIT);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException interruptedException) {
            log.error("Thread has been interrupted {}\n{}", interruptedException, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
