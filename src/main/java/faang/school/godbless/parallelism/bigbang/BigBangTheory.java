package faang.school.godbless.parallelism.bigbang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = new ArrayList<>(Arrays.asList(
                new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experiment modeling"),
                new Task("Howard", "Tools developing"),
                new Task("Sheldon", "Data analyzing")
        ));
        List<Future<?>> futures = new ArrayList<>();
        for (Task task : tasks) {
            futures.add(executorService.submit(task));
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted");
            } catch (ExecutionException e) {
                System.out.println("Task execution failed");
            }
        }
        executorService.shutdown();
        System.out.println("All tasks finished successfully");
    }

}
