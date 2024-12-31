package school.faang.sprint4.bjs_50802;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
public class Tournament {
    private static final int TASK_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.difficulty() * TASK_TIME);
                school.updatePoints(task.reward());
                log.info("Run task {} for school {}", task.name(), school.name());
            } catch (InterruptedException e) {
                log.error("Task was interrupted");
                Thread.currentThread().interrupt();
            }
            return school;
        }, executor);
    }
}
