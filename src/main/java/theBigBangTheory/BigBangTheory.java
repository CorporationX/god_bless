package theBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int NUMBER_OF_THREADS = 4;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        Task taskForSheldon = new Task("Sheldon", "Theory preparation");
        Task taskForLeonard = new Task("Leonard", "Experiment simulation");
        Task taskForHoward = new Task("Howard", "Tool development");
        Task taskForRajesh = new Task("Rajesh", "Data analysis");
        List<Task> tasks = List.of(taskForSheldon, taskForLeonard, taskForHoward, taskForRajesh);

        tasks.forEach(executor::execute);
        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks is completed");
    }
}
