package school.faang.threewizardchallenge;

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

            school.getStudents().forEach(student -> {
                int newPoints = student.getPoints() + task.getReward();
                student.setPoints(newPoints);
            });

            System.out.println(school.getName() + " completed the task: " + task.getName());
            return school;
        });
    }
}
