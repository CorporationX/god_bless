package school.faang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TERMINATION_TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Task> tasks = List.of(
                new Task("Sheldon", "preparing the theory"),
                new Task("Leonard", "experiment modeling"),
                new Task("Howard", "tool development"),
                new Task("Rajesh", "data analysis")
        );

        tasks.forEach(executor::execute);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Tasks haven't been completed in time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
