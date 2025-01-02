package derschrank.sprint04.task03.bjstwo_51033;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error("Tournament was interrupted: " + e);
                    }
                    return school.updatePoints(task);
                })
                .exceptionally(e -> school);
    }
}
