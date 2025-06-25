package school.faang.bj2_82763;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private static final int DIFFICULTY_UNIT_MS = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.getDifficulty() * DIFFICULTY_UNIT_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task execution interrupted", e);
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }

            return school;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
