package faang.school.godbless.ThreeWizardsTournament;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private static final Random RANDOM = new Random();
    private static final int NUM_THREADS = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<School> startTask(School school, Task task) {
        Student student = school.getTeam().get(RANDOM.nextInt(school.getTeam().size()));
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            student.setPoints(student.getPoints() + task.getReward());
            return school;
        }, EXECUTOR);
    }

    public static void shutdownTournament() {
        EXECUTOR.shutdown();
    }
}