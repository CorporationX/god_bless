package faang.school.godbless.triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newFixedThreadPool(school.getTeam().size());

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(task.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student ->
                    CompletableFuture.runAsync(() -> student.setPoints(student.getPoints() + task.getReward()), executorService));
            executorService.shutdown();
            return school;
        });
    }
}