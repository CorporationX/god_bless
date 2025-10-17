package school.faang.mehrmagie;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.getTeam().stream().forEach(student ->
                    student.setPoints(student.getPoints() + task.getReward()));

            return school;
        });
    }
}
