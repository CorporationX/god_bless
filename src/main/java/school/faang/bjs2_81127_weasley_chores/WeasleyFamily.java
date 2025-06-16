package school.faang.bjs2_81127_weasley_chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {
                new Chore("dishes"),
                new Chore("vacuuming"),
                new Chore("mopping")
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
