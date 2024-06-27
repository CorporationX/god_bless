package faang.school.godbless.async.wizards;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    private final Random random = new Random();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            updateStudentPoints(school, task);
            return school;
        });
    }

    private void updateStudentPoints(School school, Task task) {
        school.getTeam().forEach(student -> {
            int additionalPoints = task.getReward() * random.nextInt(task.getDifficulty());
            student.setPoints(student.getPoints() + additionalPoints);
        });
    }
}
