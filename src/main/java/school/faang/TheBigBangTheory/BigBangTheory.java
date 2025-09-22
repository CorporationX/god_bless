package school.faang.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int AWAIT_TERMINATION_TIMEOUT = 10;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Task[] tasks = {
                new Task("Sheldon", "Build a superstring control"),
                new Task("Leonard", "Conduct an experiment"),
                new Task("Raj", "Write an article"),
                new Task("Howard", "Build a device")
        };

        for (Task task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("All tasks have completed, the thread pool has stopped.");
    }
}
