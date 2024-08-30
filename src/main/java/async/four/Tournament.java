package async.four;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(school.getName() + " start task " + task.getName());
            try {
                Thread.sleep(task.getDifficult() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task interrupted");
            }
            System.out.println(school.getName() + " completed the task " + task.getName());
            return school;
        }, executor).thenApplyAsync(schol -> {
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            System.out.println("All students of the school " + school.getName() +
                    " received an award " + task.getReward());
            System.out.println("Total school " + schol.getName() + " points: " + schol.getTotalPoints());
            return school;
        }, executor).whenComplete((result, exception) -> executor.shutdown());
    }
}
