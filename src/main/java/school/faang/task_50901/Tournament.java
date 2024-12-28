package school.faang.task_50901;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long EXECUTION_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * EXECUTION_TIME);
            } catch (InterruptedException e) {
                log.error("Поток был прерван при выполнении метода sleep()", e);
            }
            school.getStudents().forEach(student -> student.updatePoints(task.reward()));
            return school;
        });
    }
}
