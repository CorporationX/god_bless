package faang.school.godbless.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        System.out.println(school.getName() + " starts a task: " + task.getName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            school.getTeam().forEach(student -> {
                student.setPoints(student.getPoints() + task.getDifficulty());
            });

            return school;
        }, executorService);
    }
}
