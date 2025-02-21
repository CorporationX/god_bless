package school.faang.task_61170;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Howard", "development of tools"),
                new Task("Rajesh", "data analysis")
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        tasks.forEach(executor::submit);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks are completed within the specified time period.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
