package school.faang.BJS2_62367;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(@NonNull School school, @NonNull Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task interrupted", e);
            }
            school.updatePoints(task.getReward());
            return school;
        });
    }
}
