package school.faang.task_51709;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(school.getName() + " is starting the task: " + task.getName());
                Thread.sleep(task.getDifficulty() * 1000L);
                school.addPointsToTeam(task.getReward());
                System.out.println(school.getName() + " has completed the task: " + task.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}
