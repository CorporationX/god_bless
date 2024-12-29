package school.faang.task_51062;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread {} was interrupted", Thread.currentThread().getName(), e);
                log.error("Error message in {} and {}: ", school, task, e);
            }

            if (!Thread.currentThread().isInterrupted()) {
                school.team()
                        .forEach(student -> student.addPoints(task.reward()));

            }

            return school;
        });
    }

}
