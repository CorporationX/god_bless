package faang.school.godbless.multithreading.async.tournamentThreeWizard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<CompletableFuture<Student>> completableFutures = new ArrayList<>();

        for (Student student : school.getTeam()) {
            CompletableFuture<Student> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(task.getDifficulty() * 1_000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                student.setPoints(student.getPoints() + task.getReward());
                return student;

            }, executor);
            completableFutures.add(completableFuture);
        }
        executor.shutdown();

        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenApply(var -> school);
    }
}
