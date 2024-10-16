package school.faang.bigbang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static final int THREAD_PULL_COUNT = 4;

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Sheldon", "Theoretical analysis"),
                new Task("Leonard", "Experiment design"),
                new Task("Howard", "Toolkit development"),
                new Task("Rajesh", "Data analysis")
        );
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_PULL_COUNT);

        tasks.forEach(executor::submit);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Some tasks were not completed in expected time. Closing running tasks.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread execution has been unexpectedly interrupted. Closing running tasks. ");
            e.printStackTrace();
            executor.shutdownNow();
        }
        System.out.println("All tasks were closed now");
    }
}
