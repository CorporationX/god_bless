package school.faang.triwizard.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            long taskCompletionTime = (long) task.getDifficulty() * 1000;

            try {
                Thread.sleep(taskCompletionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            school.getTeam().forEach(s -> s.setPoints(task.getReward() + s.getPoints()));

            return school;
        });
    }
}
