package school.faang.bjs_50846;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Slf4j
public class Tournament {
    private static final int THREAD_POOL_SIZE = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(schoolTask(school, task), executor);
    }

    private Supplier<School> schoolTask(School school, Task task) {
        return () -> {
            log.info("Starting task {} for school {}", task.getName(), school.getName());
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Interrupted while waiting for task {}", task.getName());
            }

            synchronized (school) {
                updatePoints(school, task.getReward());
            }

            log.info("Finished task {}", task.getName());
            return school;
        };
    }

    private void updatePoints(School school, int reward) {
        school.getTeam().forEach(student -> student.setPoints(student.getPoints() + reward));
    }
}
