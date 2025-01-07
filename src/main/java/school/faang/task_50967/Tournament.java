package school.faang.task_50967;

import java.util.concurrent.*;

public class Tournament {
    private static final int DELAY_MULTIPLIER = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.getDifficulty() * DELAY_MULTIPLIER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task execution interrupted", e);
            }

            school.addPointsToTeam(task.getReward());
            return school;
        });
    }
}