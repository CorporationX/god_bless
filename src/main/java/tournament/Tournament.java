package tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
                school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            } catch (InterruptedException e) {
                log.error("Task was interrupted", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return school;
        });
    }
}
