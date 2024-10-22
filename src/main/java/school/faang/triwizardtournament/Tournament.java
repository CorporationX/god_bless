package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    public static final int EASY_DIFFICULTY = 1000;
    public static final int MEDIUM_DIFFICULTY = 2000;
    public static final int HARD_DIFFICULTY = 3000;
    public static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                calculationAndScoringOfTaskDifficulty(school, task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("A sleeping thread is interrupted by another thread: {}", e);
            }
            return school;
        }, executor);
    }

    public void calculationAndScoringOfTaskDifficulty(School school, Task task) throws InterruptedException {
        switch (task.getDifficulty()) {
            case "Easy":
                Thread.sleep(EASY_DIFFICULTY);
                isTeamCompletedTask(school, task);
                break;
            case "Medium":
                Thread.sleep(MEDIUM_DIFFICULTY);
                isTeamCompletedTask(school, task);
                break;
            case "Hard":
                Thread.sleep(HARD_DIFFICULTY);
                isTeamCompletedTask(school, task);
                break;
        }
    }

    public void isTeamCompletedTask(School school, Task task) {
        Random random = new Random();
        if (random.nextBoolean()) {
            school.getTeam()
                    .forEach(student -> student.addPoints(task.getReward()));
            log.info("The {} team is doing the {} task" +
                    " and earns {} points", school.getName(), task.getName(), school.getTotalPoints());
        } else {
            log.info("The {} team failed to complete the task {}", school.getName(), task.getName());
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
