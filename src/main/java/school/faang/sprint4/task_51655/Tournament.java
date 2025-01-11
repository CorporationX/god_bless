package school.faang.sprint4.task_51655;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * MILLIS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            school.getTeam().forEach(team -> {
                team.addPoints(task.getReward());
            });
            return school;
        });
    }

    private static final long MILLIS_IN_SECOND = 1000;
}
