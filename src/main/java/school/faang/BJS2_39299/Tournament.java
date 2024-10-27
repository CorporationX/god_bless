package school.faang.BJS2_39299;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(task.getDefficulty() * 1000);
                int pointPerStudent = task.getReward() / school.getStudents().size();
                school.getStudents().forEach(student -> student.addPoints(pointPerStudent));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}
