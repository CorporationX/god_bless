package school.faang.threewizardtournament;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Выполнение задания было прервано ошибкой {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getDifficulty()));
            return school;
        });
    }
}
