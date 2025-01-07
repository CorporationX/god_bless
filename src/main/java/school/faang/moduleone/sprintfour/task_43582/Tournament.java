package school.faang.moduleone.sprintfour.task_43582;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private final ExecutorService executor;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Ошибка при выполнении задачи: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e.getCause());
            }
            school.updateStudentsPointsWithReward(task.getReward());

            return school;
        }, executor);
    }
}
