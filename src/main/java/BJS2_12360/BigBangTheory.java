package BJS2_12360;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Sheldon", "Solve physics problem"),
                new Task("Leonard", "Write research paper"),
                new Task("Howard", "Design space equipment"),
                new Task("Raj", "Analyze star data"));
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        tasks.forEach(executorService::submit);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("TIME OUT");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
        System.out.println("DONE");
    }
}
