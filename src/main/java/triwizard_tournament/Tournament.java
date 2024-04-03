package triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}