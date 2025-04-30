package school.faang.harry_potter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Школа {} начинает выполнение задания: {}", school.getName(), task.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());

                school.addPointsToTeam(task.getReward());

                log.info("Школа {} выполнила задание {} и получила {} очков",
                        school.getName(), task.getName(), task.getReward());
                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание {} было прервано для школы {}", task.getName(), school.getName(), e);
                throw new RuntimeException("Выполнение задания прервано", e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
