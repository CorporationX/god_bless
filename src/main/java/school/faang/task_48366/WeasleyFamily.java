package school.faang.task_48366;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash dishes", "sweep the floor", "cook dinner", "feed the owl"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Not all tasks completed on time. Forced termination...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted. Forced termination...");
            executor.shutdownNow();
        }

        System.out.println("All tasks are completed!");
    }
}