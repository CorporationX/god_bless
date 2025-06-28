package school.faang.module4.hogwarts;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long SLEEP_TIME_IN_MS = 1_000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("\"{}\" start \"{}\" task", school.getName(), task.getName());
            try {
                Thread.sleep(SLEEP_TIME_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.receivePoints(task.getRewards());
            log.info("\"{}\" ended \"{}\" task", school.getName(), task.getName());
            return school;
        });
    }

}
