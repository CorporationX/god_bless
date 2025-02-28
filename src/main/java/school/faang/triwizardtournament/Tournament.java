package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.info(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
            for (Student student : school.getStudents()) {
                student.addPoint(task.getReward());
            }
            log.info("Школа: {} успешно выполнила задачу: {}", school.getName(), task.getName());
            return school;
        });
    }
}
