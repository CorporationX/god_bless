package faang.school.godbless.sprint4.triwizardTournament;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class Tournament {
    private ExecutorService executor;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> school, executor)
                .thenApply(skilledSchool -> {
                    skilledSchool.getStudents()
                            .forEach(student -> student.setPoints(student.getPoints() + task.getDifficulty() * task.getReward()));
                    return skilledSchool;
                });
    }
}
