package school.faang.magicaltournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> changePoint(school, task));
    }

    public School changePoint(School school, Task task) {
        try {
            Thread.sleep(10L * task.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        school.getTeam().forEach(student -> student.addPoints(task.getReward()/(school.getTeam().size())));
        return school;
    }
}
