package school.faang.sprint_4.task_bjs250835;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private static final long WAIT_MULTIPLIER = 1000L;
    private final ExecutorService executorService;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * WAIT_MULTIPLIER);
            } catch (InterruptedException e) {
                log.warn("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
            school.updateStudentPoints(task.reward());
            return school;
        }, executorService);
    }
}
