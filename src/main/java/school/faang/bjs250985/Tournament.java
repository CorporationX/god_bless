package school.faang.bjs250985;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    private static final long CONVERT_MS = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The task {} has started", task.name());

            try {
                Thread.sleep(task.difficulty() * CONVERT_MS);
            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }

            school.updateStudentPoints(school.students(), task);
            return school;
        });
    }
}