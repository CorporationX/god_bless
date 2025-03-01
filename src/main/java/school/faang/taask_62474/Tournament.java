package school.faang.taask_62474;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток прерван: " + e);
            }
            school.getTeam().forEach(student ->
                    student.addPoints(task.getReward()));
            return school;
        });
    }
}
