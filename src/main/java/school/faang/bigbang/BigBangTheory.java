package school.faang.bigbang;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD_NUMBER = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);

        List<Task> tasks = List.of(new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experiment modelling"),
                new Task("Howard", "Instruments development"),
                new Task("Radzhesh", "Data analysis"));

        for (Task task : tasks) {
            executor.submit(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("The running was interrupted", e);
        }
    }
}
