package school.faang.task_51070;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {

    public static CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<School> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() + 1000);
                school.getStudents().forEach(student -> student.setPoints(student.getPoints() + 1));
                return school;
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения задания" + e);
                throw new RuntimeException(e);
            }
        }, executorService);

        completableFuture.whenComplete((result, throwable) -> {
            executorService.shutdown();
        });

        return completableFuture;
    }
}
