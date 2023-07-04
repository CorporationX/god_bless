package faang.school.godbless.TriwizardTournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<Integer> taskFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return task.getReward();
        });
        Integer reward;
        try {
            reward = taskFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> {
            school.addPointsToTeam(reward);
            return school;
        });
    }
}
