package school.faang.nicebutpoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {
        Chore[] chores = {
                new Chore("Wash the dishes"),
                new Chore("Cook dinner"),
                new Chore("Clean the table"),
                new Chore("Mop the floor"),
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Tasks were not completed during 1 min, terminating...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
