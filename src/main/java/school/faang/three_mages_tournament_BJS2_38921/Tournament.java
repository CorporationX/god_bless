package school.faang.three_mages_tournament_BJS2_38921;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        final long TO_SECOND = 1000;
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * TO_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            school.getStudents().forEach((student) ->
                    student.setPoints(student.getPoints() + task.getReward()));

            executorService.shutdown();
            return school;
        }, executorService);
    }
}