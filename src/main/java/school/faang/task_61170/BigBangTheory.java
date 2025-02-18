package school.faang.task_61170;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        Task sheldonTask = new Task("Sheldon", "theory preparation");
        Task leonardTask = new Task("Leonard", "simulation of an experiment");
        Task howardTask = new Task("Howard", "development of tools");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(sheldonTask);
        executor.execute(leonardTask);
        executor.execute(howardTask);
        executor.execute(rajeshTask);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Not all tasks are completed within the specified time period.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
