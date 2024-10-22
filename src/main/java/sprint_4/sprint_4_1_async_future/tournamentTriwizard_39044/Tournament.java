package sprint_4.sprint_4_1_async_future.tournamentTriwizard_39044;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
@NoArgsConstructor
public class Tournament {
    private static final long ONE_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            long timeOnTask = task.getDifficulty() * ONE_TIME;
            log.info("School {} started task: {}", school.getName(), task.getName());
            sleepThread(timeOnTask);
            school.getStudents().forEach(student -> student.addPoints(task.getReward()));
            log.info("School {} finished task.", school.getName());
            return school;
        });
    }

    private void sleepThread(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread is dead: {}", Thread.currentThread().getName());
        }
    }
}
