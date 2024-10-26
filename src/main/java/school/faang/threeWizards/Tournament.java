package school.faang.threeWizards;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    final int THREAD_POOL = 5;
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
                executor.shutdown();
            } catch (InterruptedException e) {
                log.error("Начало задания было прервано.");
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
