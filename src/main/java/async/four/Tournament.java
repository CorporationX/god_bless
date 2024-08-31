package async.four;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {

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
        }).thenApplyAsync(schol -> {
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            System.out.println("All students of the school " + school.getName() +
                    " received an award " + task.getReward());
            System.out.println("Total school " + schol.getName() + " points: " + schol.getTotalPoints());
            return school;
        });
    }
}
