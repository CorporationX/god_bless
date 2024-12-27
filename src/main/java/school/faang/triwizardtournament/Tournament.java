package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public static final int DURATION_MS = 1;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Task {} is performed by the school {}", task.name(), school.getName());
                Thread.sleep(task.difficult() * DURATION_MS);
            } catch (InterruptedException e) {
                log.error("Execution was interrupted");
                Thread.currentThread().interrupt();
            }
            school.getTeam().forEach(student -> student.addPoints(task.reward()));
            school.getTotalPoints();
            return school;
        });
    }
}
