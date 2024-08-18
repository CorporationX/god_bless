package faang.school.godbless.thebigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experimental simulation"),
                new Task("Rajesh", "Data analysis"),
                new Task("Howard", "Tool development")
        );
        tasks.forEach(executorService::execute);
        executorService.shutdown();
        try {
            executorService.awaitTermination(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks have been completed");
    }
}