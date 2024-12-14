package school.faang.triwizard_tournament.main_code;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
           school.getTeam().forEach(student -> student.addPoints(task.getReward()));
           return school;
        });

        return future;
    }
}
