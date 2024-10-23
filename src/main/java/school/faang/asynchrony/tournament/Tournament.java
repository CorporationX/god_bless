package school.faang.asynchrony.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private final int THREAD_SLEEP_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
        return futureResult;
    }

}
