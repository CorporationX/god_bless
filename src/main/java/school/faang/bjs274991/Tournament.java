package school.faang.bjs274991;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {
    private static final int TIME_OUT = 5;
    private static final long MULTIPLIER = 1000L;
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s begin %s (%s)%n", school.getName(), task.getName(), Thread.currentThread().getName());
            try {
                Thread.sleep(task.getDifficulty() * MULTIPLIER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.setPoints(student.getPoints() + task.getReward() / school.getTeam().size());
            }
            System.out.printf("%s end %s (%s)%n", school.getName(), task.getName(), Thread.currentThread().getName());
            school.setFinishTime(System.currentTimeMillis());
            return school;

        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.MINUTES)) {
                System.out.printf("%s end shutdown%n", Thread.currentThread().getName());
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}