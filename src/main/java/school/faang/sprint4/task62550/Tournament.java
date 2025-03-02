package school.faang.sprint4.task62550;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long FACTOR = 1_000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * FACTOR);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(Thread.currentThread().getName() + " was interrupted." + e.getMessage());
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
