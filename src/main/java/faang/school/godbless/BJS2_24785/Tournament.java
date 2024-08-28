package faang.school.godbless.BJS2_24785;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    private final Random random = new Random();
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * (1 + random.nextInt(6)));
            } catch (InterruptedException e) {
                throw new RuntimeException("Sleep error");
            }

            int rewardPoints = task.getRewardPoints();
            school.getStudents()
                    .forEach(student -> {
                        int oldPoints = student.getPoints();
                        student.setPoints(oldPoints + rewardPoints);
                    });

            return school;
        });
    }
}
