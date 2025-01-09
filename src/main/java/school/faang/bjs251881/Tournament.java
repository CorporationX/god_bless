package school.faang.bjs251881;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public static final long TIME_TASK_COMPLETION = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> compete(school, task));
    }

    private School compete(School school, Task task) {
        try {
            Thread.sleep(task.getDifficulty() * TIME_TASK_COMPLETION);
        } catch (InterruptedException ex) {
            log.error("The task has been aborted! {}", String.valueOf(ex));
            Thread.currentThread().interrupt();
        }
        school.updatePoints(task);
        return school;
    }
}
