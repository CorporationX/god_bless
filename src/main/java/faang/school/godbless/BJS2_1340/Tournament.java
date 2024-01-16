package faang.school.godbless.BJS2_1340;

import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NoArgsConstructor
public class Tournament {

    public CompletableFuture<School> startTask (School school, Task task) {
        ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
        CompletableFuture<School> taskResult = CompletableFuture.supplyAsync(() -> {
           school.getTeam().forEach(student -> student.setPoints(performTask(student, task)));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return school;
        }, executor);
        taskResult.thenRun(executor::shutdown);
        return taskResult;
    }

    private int performTask(Student student, Task task) {
        int difficulty = task.getDifficulty();
        int reward = task.getReward();

        return difficulty * reward;
    }
}