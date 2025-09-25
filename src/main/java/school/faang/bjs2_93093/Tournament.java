package school.faang.bjs2_93093;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {
    private static final int GET_MILLIS = 100;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

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

    public void shutdownExecutorService(long timeoutInSeconds) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(timeoutInSeconds, TimeUnit.SECONDS)) {
                System.err.println("Threads haven't stopped.");
                executorService.shutdownNow();
                if (!executorService.awaitTermination(timeoutInSeconds, TimeUnit.SECONDS)) {
                    System.err.println("Threads haven't stopped even with shutdownNow()");
                }
            }

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupt while wait the ending of executorService");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}