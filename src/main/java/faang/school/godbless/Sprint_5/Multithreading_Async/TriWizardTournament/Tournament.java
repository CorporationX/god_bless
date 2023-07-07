package faang.school.godbless.Sprint_5.Multithreading_Async.TriWizardTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            int rew = task.getReward();
            school.getTeam().stream().forEach(student -> student.setPoints(student.getPoints() + rew));
            return school;
        });
    }
}
