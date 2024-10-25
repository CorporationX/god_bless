package school.faang.threemagicians;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public CompletableFuture<School> startTask(School school, Task task){
        CompletableFuture<School> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Выполнение задачи...");
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка в потоке: " + e.getMessage());
            }
            school.getStudents().stream().map(student -> student.getPoints() + 1).mapToInt(Integer::intValue).sum();

            System.out.println("Задача " + task.getName() + " выполнена.");

            return school;
        }, executorService);

        executorService.shutdown();

        return completableFuture;
    }
}
