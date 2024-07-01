package faang.school.godbless.theTriwizardTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            school.getTeam().stream().forEach(student -> {
                student.setPoints(student.getPoints() + task.getReward());
            });
            return school;
        });

        return future;
    }
}
