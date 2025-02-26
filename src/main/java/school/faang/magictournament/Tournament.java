package school.faang.magictournament;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final int DELAY_PER_DIFFICULT = 2000;

    public CompletableFuture<School> startTask(School school, Task task) throws InterruptedException {
        validateParams(school, task);
        imitateDelay(task);
        school.team().forEach(student -> student.addPoints(task.reward()));
        return CompletableFuture.completedFuture(school);
    }

    private void imitateDelay(Task task) throws InterruptedException {
        Thread.sleep((long) DELAY_PER_DIFFICULT * task.difficulty());
    }

    private void validateParams(School school, Task task) {
        Objects.requireNonNull(task, "Invalid task value");
        Objects.requireNonNull(school, "Invalid school value");
    }
}
