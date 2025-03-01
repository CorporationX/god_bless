package school.faang.triwizard.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s is performing the task: %s...%n", school.getName(), task.getName());
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            System.out.printf("%s completed the task: %s and earned %d points%n", school.getName(), task.getName(),
                    task.getReward());
            return school;
        });
    }
}
