package school.faang.bjs2_62378;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            int pointsPerStudent = task.getReward() / school.getStudents().size();
            school.getStudents().forEach(student -> student.setPoints(student.getPoints() + pointsPerStudent));

            return school;
        });
    }
}
