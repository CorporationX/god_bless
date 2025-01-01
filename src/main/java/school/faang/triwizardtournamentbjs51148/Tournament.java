package school.faang.triwizardtournamentbjs51148;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final Logger logger = LoggerFactory.getLogger(Tournament.class);
    private static final int TIME_MULTIPLIER = 1000;

    public CompletableFuture<School> startTask(School school,
                                               Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("{} is starting task: {}", school.getName(), task.getName());
                Thread.sleep(task.getDifficulty() * TIME_MULTIPLIER);
                school.getTeam().forEach(student ->
                        student.addPoints(task.getReward()));
                logger.info("{} completed task: {} and earned {} points", school.getName(),
                        task.getName(), task.getReward());
            } catch (InterruptedException e) {
                logger.error("Task interrupted for school: {}", school.getName(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return school;
        });
    }
}
