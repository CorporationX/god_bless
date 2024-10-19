package school.faang.BJS2_36703_BigBangTheory;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TERMINATION_WAIT_SECONDS = 10;
    private static final String[] workers = {"Sheldon ", "Leonard ", "Howard ", "Rajesh "};
    private static final String[] tasksNames = {
            "preparation of the theory",
            "simulation of the experiment",
            "development of tools",
            "data analysis"
    };

    public static void main(String[] args) {
        Task[] tasks = {
                new Task(workers[0], tasksNames[0]),
                new Task(workers[1], tasksNames[1]),
                new Task(workers[2], tasksNames[2]),
                new Task(workers[3], tasksNames[3])
        };

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Arrays.stream(tasks).forEach(service::submit);

        service.shutdown();

        try {
            if (service.awaitTermination(TERMINATION_WAIT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("All the tasks have been correctly finished.");
            } else {
                System.out.println("Not all tasks have been correctly finished. Shutting down executor service.");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new IllegalStateException(
                    "The thread was interrupted while waiting for tasks to finish. Shutting down executor service.",
                    e
            );
        }
    }
}
