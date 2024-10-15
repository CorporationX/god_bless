package school.faang.weasley;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final List<String> CHORES = new ArrayList<>();

    public void addChore(String chore) {
        CHORES.add(chore);
    }

    public void executeTasks() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : CHORES) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Not all the tasks were completed in the given timeframe");
                executor.shutdownNow();
            } else {
                System.out.println("All chores have been completed successfully!");
            }
        } catch (InterruptedException e) {
            System.out.println("Execution was interrupted.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}