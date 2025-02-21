package school.faang.bjs2_60723;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] HOUSEHOLD_TASKS = {"wash the dishes", "sweep the floor",
            "cook dinner", "wash the clothes", "dust"};
    private static final int TERMINATION_TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : HOUSEHOLD_TASKS) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Main thread was interrupted while waiting for executor termination", e);
        }
        System.out.println("All the work is done!");
    }
}