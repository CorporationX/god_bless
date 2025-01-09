package school.faang.task_51119;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting task: {}", school.getName(), task.name());
                Thread.sleep(task.difficulty() * 1000L);
                school.addPointsToTeam(task.rewards());
                log.info("{} complete task: {} and earned {} points",
                        school.getName(), task.name(), task.rewards());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Task {} was interrupted for {}", task.name(), school.getName());
            }

            return school;
        });
    }
}
