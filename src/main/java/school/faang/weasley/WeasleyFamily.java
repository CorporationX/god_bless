package school.faang.weasley;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Slf4j
public class WeasleyFamily {
    private final List<String> chores = new ArrayList<>();

    public void addChore(String chore) {
        chores.add(chore);
    }

    public void executeTasks() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
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
            log.debug("Execution was interrupted.", e);
            e.printStackTrace();
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}