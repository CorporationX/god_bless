package faang.school.godbless.multithreadingS4.bigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Howard", "development of tools"),
                new Task("Rajesh", "data analysis")
        );

        tasks.forEach(executorService::execute);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(120, TimeUnit.SECONDS)) {
                System.out.println("\nExecutor service terminated successfully.");
            } else {
                executorService.shutdownNow();
                System.out.println("Executor service terminated forcibly");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            e.getStackTrace();
        }

    }
}
