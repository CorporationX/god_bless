package BJS2_24080_TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Theory");
        Task task2 = new Task("Leonard", "Modelling");
        Task task3 = new Task("Govard", "Development");
        Task task4 = new Task("Radjesh", "Analyze");
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
