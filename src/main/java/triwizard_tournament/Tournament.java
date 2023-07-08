package triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            school.getStudents()
                    .stream()
                    .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}
