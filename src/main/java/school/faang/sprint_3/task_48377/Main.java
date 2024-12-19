package school.faang.sprint_3.task_48377;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        for (Chore task : weasleyFamily.chores) {
            executor.submit(task);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                System.out.println("Tasks not completed in 2 minutes, forced stop.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error(e.getMessage());
        }
    }
}
