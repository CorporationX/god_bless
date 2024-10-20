package school.faang.threewizard;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask (School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
