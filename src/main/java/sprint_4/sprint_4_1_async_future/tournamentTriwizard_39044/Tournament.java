package sprint_4.sprint_4_1_async_future.tournamentTriwizard_39044;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final long ONE_TIME = 1000;
    private static final int WAIT_TIME_TERMINATION = 50;
    private final ExecutorService executor;

    public Tournament(int countSchool) {
        executor = Executors.newFixedThreadPool(countSchool);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            long timeOnTask = task.getDifficulty() * ONE_TIME;
            sleepThread(timeOnTask);
            school.getStudents().forEach(student -> student.addPoints(task.getReward()));
            return school;
        }, executor);
    }

    private void sleepThread(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread is dead: {}", Thread.currentThread().getName());
        }
    }

    public void shutdown() {
        executor.shutdown();
        if(!executor.awaitTermination(50, TimeUnit.SECONDS)){
            executor.shutdownNow();
            log.warn("Executor did not terminate in the specified time: {} seconds", WAIT_TIME_TERMINATION);
        }
    }
}
