package faang.school.godbless.TriwizardTournament;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    @Getter
    private ExecutorService service = Executors.newFixedThreadPool(4);

    public CompletableFuture<School> startTask(School school, Task task) {
        int rewardOneStudent = task.getReward() / school.getTeam().size();
        CompletableFuture[] completableFutures = school.getTeam().stream()
                .map(student -> CompletableFuture.runAsync(() ->
                        student.setPoints(
                                student.getPoints() + rewardOneStudent),
                        service))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(completableFutures)
                .thenApply(i -> school);
    }
}

