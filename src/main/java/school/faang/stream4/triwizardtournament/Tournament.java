package school.faang.stream4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int COEFFICIENT = 300;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * COEFFICIENT);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
            long pointsPerStudent = task.getReward() / school.getTeam().size();
            school.getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + pointsPerStudent));
            return school;
        });
    }
}
