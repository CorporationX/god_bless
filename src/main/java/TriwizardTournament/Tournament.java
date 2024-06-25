package TriwizardTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam()
                    .forEach(student -> {
                        try {
                            Thread.sleep(1000L * task.getDifficulty());
                            student.addedPoints(task.getReward());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
            return school;
        });
    }
}