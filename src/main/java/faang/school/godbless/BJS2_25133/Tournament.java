package faang.school.godbless.BJS2_25133;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Running task %s with difficulty = %d and rewards = %d%n",
                        task.getName(), task.getDifficulty(), task.getReward());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return school;
        });
    }
}
