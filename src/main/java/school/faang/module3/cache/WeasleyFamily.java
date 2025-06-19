package school.faang.module3.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
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
            executor.submit(chore::run);
        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("All chores done");
        executor.shutdown();
        System.out.printf("executor is shutdown ? %s\n", executor.isShutdown());
    }
}
