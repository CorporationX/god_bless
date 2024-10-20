package school.faang.thebigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "theory preparation");
        Task leonardTask = new Task("Leonard", "experiment modeling");
        Task howardTask = new Task("Howard", "tool development");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        executorService.submit(sheldonTask);
        executorService.submit(leonardTask);
        executorService.submit(howardTask);
        executorService.submit(rajeshTask);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Tasks did not finish in 5 minutes, forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("All tasks have been processed.");
    }
}

