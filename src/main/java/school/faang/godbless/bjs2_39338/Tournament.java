package school.faang.godbless.bjs2_39338;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Thread {} : starting task {} for school {}",
                    Thread.currentThread().getName(), task.getName(), school.getName());
            try {
                Thread.sleep(task.getDifficulty());
                school.addPoints(task.getReward());
            } catch (InterruptedException e) {
                log.error("Thread {} interrupted. Failed to complete task {} for school {}",
                        Thread.currentThread().getName(), task.getName(), school.getName());
                Thread.currentThread().interrupt();
                CompletableFuture.failedFuture(e);
            }
            return school;
        });
    }
}
