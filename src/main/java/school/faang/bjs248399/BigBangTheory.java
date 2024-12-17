package school.faang.bjs248399;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREADS_AMOUNT = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Sheldon", "theory preparation"));
        tasks.add(new Task("Leonard", "experiment modeling"));
        tasks.add(new Task("Howard", "tool development"));
        tasks.add(new Task("Rajesh", "data analysis"));

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("The tasks were not completed in 5 minutes, we forcefully stop them.");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
            executorService.shutdown();
        }
    }
}
