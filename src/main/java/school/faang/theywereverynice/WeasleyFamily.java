package school.faang.theywereverynice;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final List<Chore> CHORES = List.of(
            new Chore("task 1"), new Chore("task 2"), new Chore("task 3"),
            new Chore("task 4"), new Chore("task 5"), new Chore("task 6"),
            new Chore("task 7"), new Chore("task 8"), new Chore("task 9")
    );
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            Objects.requireNonNull(CHORES, "Chores is not initialized");
            Objects.requireNonNull(EXECUTOR_SERVICE, "Executors is not initialized");
            CHORES.forEach(EXECUTOR_SERVICE::submit);
            EXECUTOR_SERVICE.shutdown();
            boolean isTerminated = EXECUTOR_SERVICE.awaitTermination(TIME_EXECUTION, TIME_UNIT);
            if (isTerminated) {
                log.info("All done");
            } else {
                log.warn("Chores has not finished within {} {}", TIME_EXECUTION, TIME_UNIT);
                EXECUTOR_SERVICE.shutdownNow();
            }
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            EXECUTOR_SERVICE.shutdownNow();
        }
    }
}
