package wizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(task.getDifficulty());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("An error occurred while waiting for the task to complete: {}", e.getMessage(), e);
                        throw new RuntimeException(e);
                    }

                    for (Student student : school.getTeam()) {
                        student.addPoints(task.getReward());
                    }
                    return school;
                });
    }
}
