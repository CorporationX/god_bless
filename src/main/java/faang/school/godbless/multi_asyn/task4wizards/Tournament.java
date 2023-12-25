package faang.school.godbless.multi_asyn.task4wizards;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            school.getTeam().forEach(student -> student.setPoints(task.getReward() * task.getDifficulty()));

            return school;
        });
    }
}
