package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task " + task.getName() + " for " + school.getName() + " has started...");
                Thread.sleep(task.getDifficulty() * 1000);
                school.addPointsToTeam(task.getReward());
                System.out.println("Task " + task.getName() + " for " + school.getName() + " has completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}
