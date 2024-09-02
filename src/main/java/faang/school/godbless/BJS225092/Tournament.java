package faang.school.godbless.BJS225092;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} started task '{}'", school.getName(), task.getName());
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.addPointsToTeam(task.getReward());
            log.info("{} finished task '{}'", school.getName(), task.getName());
            return school;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
