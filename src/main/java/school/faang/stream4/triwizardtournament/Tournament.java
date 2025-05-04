package school.faang.stream4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int COEFFICIENT = 3;

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep((long) task.getDifficulty() * COEFFICIENT);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
            synchronized (school) {
                long pointsPerStudent = task.getReward() / school.getTeam().size();
                school.getTeam()
                        .forEach(student -> student.setPoints(student.getPoints() + pointsPerStudent));
                return school;
            }
        }, executor);
    }
}
