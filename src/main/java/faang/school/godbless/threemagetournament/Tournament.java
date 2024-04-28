package faang.school.godbless.threemagetournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("School {} start task: {}", school.getName(), task.getName());

            try {
                Thread.sleep(1000 * task.getDifficulty());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }

            school.getStudents().forEach(student -> student.incrementPoints(task.getReward()));
            return school;
        });
    }
}
