package school.faang.BJS238948;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private static final int THREADS = 3;

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        CompletableFuture<School> completableFuture = CompletableFuture.supplyAsync(() -> school, executorService);
        completableFuture.thenApply(sch -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
                int points = task.getReward();
                school.getTeam().forEach(student -> student.setPoints(student.getPoints() + points));
            } catch (InterruptedException e) {
                log.error("Something went wrong", e);
            }
            return school;
        });
        completableFuture.thenRun(executorService::shutdown);
        return completableFuture;
    }
}
