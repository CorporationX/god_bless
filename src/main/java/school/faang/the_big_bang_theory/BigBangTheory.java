package school.faang.the_big_bang_theory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        Task[] tasks = {
                new Task("Sheldon", "gather theoretical information"),
                new Task("Leonard", "model the experiment"),
                new Task("Howard", "developing tools"),
                new Task("Rajesh", "analyzing data")
        };
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (Task task : tasks) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Not all the tasks were finished in 5 minutes, forcing to stop now...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Exception in threads connected to awaitTermination method", e);
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}