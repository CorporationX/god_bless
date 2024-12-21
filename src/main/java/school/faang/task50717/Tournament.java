package school.faang.task50717;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.difficulty().getSeconds());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error message: ", e);
            }
            school.team().forEach(student -> student.addPoints(task.reward()));
            return school;
        });
    }
}
