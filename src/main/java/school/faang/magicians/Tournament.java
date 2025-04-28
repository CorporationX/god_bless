package school.faang.magicians;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            return school;
        }, ThreadPoolProvider.executorService)
                .thenApply(currentSchool -> {
                    currentSchool.getStudents().forEach(student -> student.addPoints(task.getReward()));
                    return currentSchool;
                });
    }
}
