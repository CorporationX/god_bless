package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
                school.getStudents()
                        .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                Thread.sleep(15L * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return school;
        });
    }
}
