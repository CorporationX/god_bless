package school.faang.BJS2_36687_NiceButPoor;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class WeasleyFamily {
    private List<String> chores;

    public WeasleyFamily() {
        chores = new ArrayList<>();
    }

    public void addChore(String chore) {
        chores.add(chore);
    }

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(chore -> {
            executor.execute(new Chore(chore));
        });
        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All the chores have been done!");
            } else {
                executor.shutdownNow();
                System.out.println("Not all chores have been done :(");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.err.printf("Interrupted while waiting for chores to finish. Shutting down executor now.\n%s", e.getMessage());
        }
    }
}
