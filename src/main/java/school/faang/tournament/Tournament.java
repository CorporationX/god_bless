package school.faang.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficult() * 1000);
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                log.error("Поток был прерван. ");
            }

            school.team().stream()
                    .forEach(student -> student.addPoints(task.reward()));

            return school;
        });
    }
}
