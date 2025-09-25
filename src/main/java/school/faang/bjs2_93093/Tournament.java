package school.faang.bjs2_93093;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private static final int GET_MILLIS = 100;
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public CompletableFuture<School> startTask(School school, Task task) {
        synchronized (task) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep((long) task.difficulty() * GET_MILLIS);
                } catch (InterruptedException e) {
                    System.err.printf("Thread of school %s on task %s was interrupted", school, task);
                    Thread.currentThread().interrupt();
                }
                for (Student student : school.team) {
                    student.addPoints(task.reward());
                }
                return school;
            }, executorService);
        }
    }
}