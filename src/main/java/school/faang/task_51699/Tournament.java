package school.faang.task_51699;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
                school.getTeam()
                        .forEach(student ->
                                student.setPoints(student.getPoints() + task.getReward()));
                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
