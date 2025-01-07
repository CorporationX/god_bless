package school.faang.task_51070;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {

    private static final int DEFAULT_SLEEP_TIME = 1000;

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() + DEFAULT_SLEEP_TIME);
                school.getStudents().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                return school;
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения задания" + e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, executorService);

        completableFuture.whenComplete((result, throwable) -> {
            executorService.shutdown();
        });

        return completableFuture;
    }
}
