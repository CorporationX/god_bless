package school.faang.tornament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    private static final int DELAY_MS = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }

            return school;
        });
    }
}
