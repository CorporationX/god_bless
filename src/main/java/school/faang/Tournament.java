package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Sleep was interrupted.");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            log.info("School {} completed the task {} and now has {} points.",
                    school.getName(), task.getName(), school.getTotalPoints());
            return school;
        });
    }
}
