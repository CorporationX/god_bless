package school.faang.three_wizards;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(teammate -> {
                teammate.setPoints(teammate.getPoints() + task.getReward());
                school.updateStudent(teammate);
            });
            return school;
        });
    }
}
