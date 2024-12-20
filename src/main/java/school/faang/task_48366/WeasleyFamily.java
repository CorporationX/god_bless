package school.faang.task_48366;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {
            "wash dishes", "sweep the floor", "cook dinner", "feed the owl"
    };
    private static final int AWAIT_TERMINATION_TIMEOUT = 5;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : CHORES) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TIME_UNIT)) {
                System.out.println("Not all tasks completed on time. Forced termination...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted. Forced termination...");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks are completed!");
    }
}