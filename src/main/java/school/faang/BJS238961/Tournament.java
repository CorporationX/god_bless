package school.faang.BJS238961;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> taskFuture = new CompletableFuture<>();
        taskFuture.completeAsync(() -> {
            try {
                school.getTeam().forEach(student -> {
                    int reward = task.getReward() / school.getTeam().size();
                    student.setPoints(student.getPoints() + reward);
                });
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
        return taskFuture;
    }
}
