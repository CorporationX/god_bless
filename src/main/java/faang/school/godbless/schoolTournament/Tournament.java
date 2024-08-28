package faang.school.godbless.schoolTournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newFixedThreadPool(school.getTeam().size());

        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            for (Student student : school.getTeam()) {
                student.setPoints(student.getPoints() + task.getReward() * task.getDifficulty());
            }
            return school;
        }, executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return future;
    }
}
