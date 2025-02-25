package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep((task.difficulty() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Проишла ошибка при ожидание {}", e.getMessage());
            }
            for (Student student : school.getTeam()) {
                student.addPoint(task.reward());
            }
            return school;
        });
    }
}