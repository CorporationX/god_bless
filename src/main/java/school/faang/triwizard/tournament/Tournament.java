package school.faang.triwizard.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        long taskCompletionTime = (long) task.getDifficulty() * 1000;
        ExecutorService executor = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(taskCompletionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            school.getTeam().forEach(s -> s.setPoints(task.getReward() + s.getPoints()));
            executor.shutdown();

            return school;
        }, executor);
    }
}
