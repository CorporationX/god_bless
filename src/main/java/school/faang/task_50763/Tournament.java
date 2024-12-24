package school.faang.task_50763;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private final ExecutorService executorService;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.getDifficulty() * Constants.TASK_DIFFICULTY_MULTIPLIER);
            } catch (InterruptedException e) {
                log.error("Task {} interrupted for school {}: {}", task.getName(), school.getName(), e.getMessage());
                return null;
            }

            school.getTeam().forEach(student -> student.addPoints(task.getAwardPoints()));
            log.info("Task {} completed for school {}", task.getName(), school.getName());
            return school;
        }, executorService);
    }
}