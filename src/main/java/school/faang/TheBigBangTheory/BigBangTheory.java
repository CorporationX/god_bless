package school.faang.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task t1 = new Task("Sheldon", "Build a superstring control");
        Task t2 = new Task("Leonard", "Conduct an experiment");
        Task t3 = new Task("Raj", "Write an article");
        Task t4 = new Task("Howard", "Build a device");

        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.submit(t4);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("All tasks have completed, the thread pool has stopped.");
    }
}
