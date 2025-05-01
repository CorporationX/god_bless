package faang.BJS2_74958;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(task.getDifficulty());
                        school.getStudents().forEach(student -> student.incrementPoints(task.getReward()));

                        return school;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}

