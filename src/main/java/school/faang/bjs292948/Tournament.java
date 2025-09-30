package school.faang.bjs292948;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 100L);
                school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return school;
        });
    }
}