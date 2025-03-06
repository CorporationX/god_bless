package school.faang.BJS2_62486;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final int TIME_THREAD_SLEEP = 100;

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_THREAD_SLEEP * task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student ->
                    student.addPoints(task.getReward() / school.getTeam().size()));
            return school;
        });
        return future;
    }
}
