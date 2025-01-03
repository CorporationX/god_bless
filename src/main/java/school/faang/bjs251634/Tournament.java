package school.faang.bjs251634;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs251634.model.School;
import school.faang.bjs251634.model.Task;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    private static final int SECOND = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Starting task...");
            try {
                Thread.sleep((long) task.getDifficulty() * SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Task interrupted", e);
            }
            school.getStudents().forEach(student ->
                    student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }

}
