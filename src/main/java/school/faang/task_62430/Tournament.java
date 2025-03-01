package school.faang.task_62430;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("School {} received a task: {}, difficulty: {}, reward: {}", school.getName(), task.getName(),
                    task.getDifficulty(), task.getReward());
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("School {} completed the task: {} and each student gets {} points",
                    school.getName(), task.getName(), task.getReward());
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
