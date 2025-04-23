package school.faang.bjs272970;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int SLEEP_DURATION_MIN = 1;

    List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        chores.add(chore);
    }

    public void runChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(executor::submit);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(SLEEP_DURATION_MIN, TimeUnit.MINUTES)) {
                System.out.println("Some chores didn't finish in time");
                executor.shutdownNow();
            } else {
                System.out.println("All chores finished in time");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for chores to finish");
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}