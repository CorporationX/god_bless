package faang.school.godbless.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    private static final int THREADS_COUNT = 4;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        List<Task> tasks = new ArrayList<>(
                List.of(
                        new Task("Sheldon", "theory preparation"),
                        new Task("Leonard", "experimental modeling"),
                        new Task("Gordon", "development of tools"),
                        new Task("Rajesh", "data analysis")
                )
        );

        tasks.forEach(executorService::execute);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("All tasks have been completed successfully");
            } else {
                System.out.println("Timeout: not all tasks completed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }
    }
}
