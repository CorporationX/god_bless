package school.faang.multithreading.asynchronism.triwizard.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Школа: {} начинает задание {}", school.getName(), task.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
                log.info("Школа: {} успешно завершает задание {}", school.getName(), task.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam()
                    .forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
