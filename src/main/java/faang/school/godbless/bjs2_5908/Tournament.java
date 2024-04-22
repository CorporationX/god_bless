package faang.school.godbless.bjs2_5908;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<School> futureTask = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                school.getTeam()
                        .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            }
            return school;
        }, executorService);
        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {}
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return futureTask;
    }
}
