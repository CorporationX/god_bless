package TriwizardTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int result = task.getReward() / school.getStudents().size();

            for (Student student : school.getStudents()) {
                student.setPoints(student.getPoints() + result);
            }
            return school;
        });
    }
}
