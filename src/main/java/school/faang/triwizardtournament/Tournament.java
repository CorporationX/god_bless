package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> taskCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
        return taskCompletableFuture;
    }
}
