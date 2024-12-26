package school.faang.task_50744;

import lombok.extern.slf4j.Slf4j;
import school.faang.exception.CheckException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Tournament {
    private static final long MILLIS = 1000L;

    public CompletableFuture<School> startTask(School school,
                                               Task task,
                                               ExecutorService executor) {
        if (school == null) {
            throw new CheckException("school");
        }
        if (task == null) {
            throw new CheckException("task");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * MILLIS);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        }, executor);
    }
}
