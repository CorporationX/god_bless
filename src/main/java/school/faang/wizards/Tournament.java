package school.faang.wizards;

import lombok.extern.slf4j.Slf4j;
import school.faang.wizards.domain.School;
import school.faang.wizards.domain.Task;
import school.faang.wizards.exception.TaskExecutionException;

import java.util.concurrent.CompletableFuture;

/**
 * @author Danil Pudovkin
 * @since 24.06.2025
 */
@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            var team = school.getTeam();
            team.forEach(student -> student.incrementPoints(task.reward() / team.size()));
            log.info("Команда школы {} выполняет задачу {}", school.getName(), task.name());
            try {
                Thread.sleep(task.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new TaskExecutionException(task, e);
            }
            log.info("Команда {} школы получила {} очков", school.getName(), task.reward());
            return school;
        });
    }
}
