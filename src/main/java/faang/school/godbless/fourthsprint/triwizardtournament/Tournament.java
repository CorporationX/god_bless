package faang.school.godbless.fourthsprint.triwizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            school.getTeam().stream()
                    .filter(student -> studentCompletesTask(task))
                    .forEach(student -> student.addPoints(calculatePoints(student, task)));

            return school;
        });
    }

    private boolean studentCompletesTask(Task task) {
        double dropoutRate = 0.05 * task.getDifficulty();
        return ThreadLocalRandom.current().nextDouble() > dropoutRate;
    }

    private int calculatePoints(Student student, Task task) {
        int basePoints = task.getReward();
        double levelFactor = 1 + (student.getYear() / 10.0);
        return (int) (basePoints * levelFactor);
    }
}
