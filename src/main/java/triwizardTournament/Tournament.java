package triwizardTournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        CompletableFuture<School> schoolAfterFinishedTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam()
                    .forEach((student -> student.setPoints(student.getPoints() + task.getReward())));
            return school;
        });
        service.shutdown();
        return schoolAfterFinishedTask;
    }
}
