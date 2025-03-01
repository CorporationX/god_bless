package school.faang.threewizards;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Thread was interrupted", e);
            }
            school.getTeam()
                    .forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
