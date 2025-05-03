package school.faang.three_warlock_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            school.addPointsToTeam(task.getReward());
            System.out.println("School " + school.getName() + " completed task '" + task.getName() +
                    "' and collected " + task.getReward() + " points");
            return school;
        });
    }
}
