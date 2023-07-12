package faang.school.godbless.TriwizardTournament;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    @SneakyThrows
    public CompletableFuture<School> startTask(School school, Task task) {
        Thread.sleep(task.getDifficulty() * 1000);

        CompletableFuture<School> taskResult = CompletableFuture.supplyAsync(() ->
                {
                    for (Student student : school.getTeam()) {
                        student.setPoints(student.getPoints() + task.getReward());
                        System.out.println(student.getName() + " complete task: " + task.getName());
                    }
                    return school;
                }
        );

        return taskResult;
    }
}
