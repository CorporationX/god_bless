package school.faang.bjs2_75778;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            school.getTeam().forEach(student -> {
                student.setPoints(student.getPoints() + task.getReward());
            });
            return school;
        });
    }
}