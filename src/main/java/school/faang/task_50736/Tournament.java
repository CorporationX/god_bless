package school.faang.task_50736;

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
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
            synchronized (school) {
                school.getTeam().forEach(student -> {
                    student.addPoints(task.getAwardPoints());
                });
                return school;
            }
        }, executorService);
    }
}
