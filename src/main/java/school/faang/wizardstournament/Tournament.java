package school.faang.wizardstournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Execution of thread Start Task is interrupted");
            }
            System.out.println(school.getName() + " wins " + task.getReward() + " points!");
            school.addReword(task.getReward());
            return school;
        });
    }
}
