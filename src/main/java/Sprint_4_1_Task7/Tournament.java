package Sprint_4_1_Task7;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> schoolFuture = CompletableFuture.supplyAsync(() -> {
            school.setTotalPoints(school.getTotalPoints() + task.getReward());
        })
        return CompletableFuture.completedFuture(school);

    }
}
