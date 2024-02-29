package faang.school.godbless.wizardstournament;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {

    private static final Random RANDOM = new Random();
    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> completeAttempt(school, task), EXECUTOR_SERVICE);
    }

    public void shutdownAndAwaitExecutor(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(minutes);
    }

    private School completeAttempt(School school, Task task) {
        school.getTeam().forEach(student -> {
            if (isCompletedTask()) {
                student.setPoints(student.getPoints() + task.getReward());
            }
        });
        return school;
    }

    private boolean isCompletedTask() {
        return RANDOM.nextBoolean();
    }

    private void awaitTermination(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
