package faang.school.godbless.multithreading.triwizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task, Executor threadPool){
        return CompletableFuture.supplyAsync(() -> {
            school.setRewardPointsForCompletedTasks(task.reward());
            return school;
        }, threadPool);
    }
}
