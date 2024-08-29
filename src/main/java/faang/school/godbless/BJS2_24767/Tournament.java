package faang.school.godbless.BJS2_24767;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            int coefficient = new Random().nextInt(1, 5);
            int totalReward = task.getReward() / coefficient + task.getDifficulty();

            school.getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + totalReward / school.getTeam().size()));

            performTask();
            return school;
        });
    }

    private void performTask() {
        try {
            Thread.sleep(new Random().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
