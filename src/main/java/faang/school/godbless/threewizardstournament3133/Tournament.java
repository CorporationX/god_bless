package faang.school.godbless.threewizardstournament3133;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Tournament {
    private static final Random RANDOM = new Random();

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach((student -> {
                if (isTaskCompleted(task)) {
                    student.setPoints(student.getPoints() + task.getReward());
                }
            }));
            return school;
        }, executor);
    }

    private boolean isTaskCompleted(Task task) {
        return RANDOM.nextInt(12) >= task.getDifficulty();
    }
}
