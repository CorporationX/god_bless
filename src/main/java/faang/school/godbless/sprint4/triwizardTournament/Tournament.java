package faang.school.godbless.sprint4.triwizardTournament;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getStudents()
                    .forEach(student -> student.setPoints(student.getPoints() + task.getDifficulty() * task.getReward()));
            return school;
        });
    }
}
