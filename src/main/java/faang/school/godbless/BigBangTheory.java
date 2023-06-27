package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Task> tasks = Arrays.asList(
                new Task("Sheldon", "Preparing theory"),
                new Task("Leonard", "Experiment modeling"),
                new Task("Howard", "Tool development"),
                new Task("Rajesh", "Data analysis")
        );
        for (var task : tasks) {
            executor.submit(task);
        }
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println("All tasks have been completed.");
    }
}
