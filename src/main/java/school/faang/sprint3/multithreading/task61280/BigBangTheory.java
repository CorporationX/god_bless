package school.faang.sprint3.multithreading.task61280;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int NUMBER_THREADS = 4;

    public static void main(String[] args) {
        List<Task> taskList = List.of(
                new Task("Sheldon", "theoretical preparation"),
                new Task("Leonard", "experiment modeling"),
                new Task("Howard", "tool development"),
                new Task("Rajesh", "data analysis")
        );
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
        for (Task task : taskList) {
            executorService.execute(task);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("not all tasks are completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("There was an attempt to interrupt the thread {} at [{}]",
                    System.currentTimeMillis(),
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}
