package bjs2_39009;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            school.getStudents().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
