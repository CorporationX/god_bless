package school.faang.task_50793;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Start task: {}", task.getName());
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.increasePointsForEveryStudent(task.getReward());

            return school;
        });
        log.info("School: {} get points = {}", school.getName(), task.getReward());
        return future;
    }
}
