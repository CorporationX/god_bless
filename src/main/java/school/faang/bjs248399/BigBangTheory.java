package school.faang.bjs248399;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREADS_AMOUNT = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        Task sheldonTask = new Task("Sheldon", "theory preparation");
        Task leonardTask = new Task("Leonard", "experiment modeling");
        Task howardTask = new Task("Howard", "tool development");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(howardTask);
        executorService.execute(rajeshTask);

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
