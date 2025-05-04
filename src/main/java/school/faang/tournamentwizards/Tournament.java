package school.faang.tournamentwizards;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final int SLEEP_TIME = 100;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * SLEEP_TIME);
                school.getTeam().forEach(student ->
                        student.addPoints(task.getReward()));
                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task execution interrupted" + e);
            }
        });
    }
}
