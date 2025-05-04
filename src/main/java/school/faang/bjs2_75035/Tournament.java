package school.faang.bjs2_75035;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long WAIT_PER_DIFFICULTY = 1000;
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Doing task...");
                Thread.sleep( task.getDifficulty() * WAIT_PER_DIFFICULTY);

            } catch (InterruptedException e) {
                System.out.println("Error, thread is interrupted");
                Thread.currentThread().interrupt();
            }

            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
            }
        );
    }
}
