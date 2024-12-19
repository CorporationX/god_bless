package school.faang.sprint_3.task_48241;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final Task[] tasks = {
            new Task("Sheldon", "Create theory"),
            new Task("Leonard", "Create experiment model"),
            new Task("Howard", "Create tools"),
            new Task("Rajesh", "Analyse data")
    };

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (Task task : tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Tasks not finished, shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
