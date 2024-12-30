package school.faang.magic_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private final static long SLEEP_MULTIPLIER = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getReward() * SLEEP_MULTIPLIER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam()
                    .forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
