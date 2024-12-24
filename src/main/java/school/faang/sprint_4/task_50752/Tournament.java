package school.faang.sprint_4.task_50752;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long DIFFICULTY_TIME = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * DIFFICULTY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return school;
        }).thenApplyAsync((lambdaSchool) -> {
            lambdaSchool.completeTask(task);
            return lambdaSchool;
        });
    }
}
