package school.faang.sprint_4.task_50911;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long LEAD_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * LEAD_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error message: ", e);
            }
            for (Student student : school.students()) {
                student.addPoints(task.reward());
            }
            return school;
        });
    }
}
