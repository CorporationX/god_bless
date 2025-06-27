package school.faang.bjs2_82789;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<School> taskFuture = CompletableFuture.supplyAsync(() -> {
            log.info("{} is starting task {}", school.getName(), task.getName());

            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Task {} was interrupted", task.getName());
                throw new CompletionException("Task " + task.getName() + " was interrupted", e);
            }
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            log.info("{} finished task {}", school.getName(), task.getName());

            return school;
        }, executorService);

        executorService.shutdown();

        return taskFuture;
    }
}
