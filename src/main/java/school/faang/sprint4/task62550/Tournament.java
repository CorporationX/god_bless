package school.faang.sprint4.task62550;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        try {
            Thread.sleep(task.getDifficulty() * 1_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(Thread.currentThread().getName() + " was interrupted." + e.getMessage());
        }
        return CompletableFuture.runAsync(() -> school.getTeam().forEach(student ->
                student.addPoints(task.getReward()))).thenApply(ignore -> school);
    }
}
