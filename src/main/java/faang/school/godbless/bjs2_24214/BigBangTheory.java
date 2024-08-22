package faang.school.godbless.bjs2_24214;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREADS_AMOUNT = 4;
    private static final long TIMEOUT = 5L;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Howard", "development of tools"),
                new Task("Rajesh", "data analysis")
        );

        tasks.forEach(executorService::execute);
        executorService.shutdown();

        try {
            boolean awaitTerminationResult = executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
            System.out.println("Await termination result" + awaitTerminationResult);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        System.out.println("All tasks have been completed");
    }
}
