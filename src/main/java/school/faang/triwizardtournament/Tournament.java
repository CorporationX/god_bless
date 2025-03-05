package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        Executor delayedExecutor = CompletableFuture.delayedExecutor(task.getDifficulty(), TimeUnit.SECONDS);

        return CompletableFuture.supplyAsync(() -> {
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        }, delayedExecutor);
    }
}
