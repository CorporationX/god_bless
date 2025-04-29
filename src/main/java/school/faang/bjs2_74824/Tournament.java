package school.faang.bjs2_74824;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        try {
            TimeUnit.SECONDS.sleep(task.getDifficulty());

            return CompletableFuture.supplyAsync(() -> {
                school.getTeam()
                        .forEach(student -> student.updatePoints(task.getReward()));
                return school;
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
