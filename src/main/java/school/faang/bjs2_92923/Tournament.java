package school.faang.bjs2_92923;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private final ExecutorService ex = Executors.newFixedThreadPool(5);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000L * task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Task {} delayed interrupted: {}", task.getName(), e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> {
                student.addPoints(task.getRewardPoints());
                log.info("{} gained {} points, current points: {}", student.getName(), task.getRewardPoints(),
                        student.getPoints());
            });
            log.info("{}  points after completing {} : {}", school.getName(), task.getName(), school.getTotalPoints());
            return school;
        }, ex);
    }

    public void executorShutdown() throws InterruptedException {
        ex.shutdown();
        if (!ex.awaitTermination(30, TimeUnit.SECONDS)) {
            log.error("Executor didn't terminate in time, shutting down");
            ex.shutdownNow();
        }
    }
}
