package school.faang.module3.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = new Chore[]{
                new Chore("Do the dishes"),
                new Chore("Take out the trash"),
                new Chore("Make the bed"),
                new Chore("Vacuum the floor"),
                new Chore("Do the laundry"),
                new Chore("Hang the clothes"),
                new Chore("Sweep the floor"),
                new Chore("Cook dinner"),
                new Chore("Wash the Window"),
                new Chore("Water the plants")
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.execute(chore::run);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("not all chores are terminated before timeout. start force termination");
                executor.shutdownNow();
            }
            System.out.println("All chores done");
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException);
            executor.shutdownNow();
        }

    }
}
