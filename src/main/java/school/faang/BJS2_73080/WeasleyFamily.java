package school.faang.BJS2_73080;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        final int MAX_WAIT_MINUTES = 2;
        String[] choreNames = {
                "Wash the dishes",
                "Iron the clothes",
                "Prepare dinner",
                "Clean the house",
                "Wash the car",
                "Pick up the groceries",
                "Do the laundry"
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String choreName : choreNames) {
            executor.submit(() -> new Chore(choreName), choreName);
            System.out.println("Assigned " + choreName + " to " + Thread.currentThread().getName());
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Not all the tasks are finished in " + MAX_WAIT_MINUTES + " minutes. " +
                        "Force completion...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Waiting for threads to complete is interrupted.");
            executor.shutdownNow();
        }

        System.out.println("All tasks are completed!");
    }
}