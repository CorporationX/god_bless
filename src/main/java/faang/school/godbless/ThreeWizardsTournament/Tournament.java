package faang.school.godbless.ThreeWizardsTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() + 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.addPoints(task.getReward());
            return school;
        });
    }
}
