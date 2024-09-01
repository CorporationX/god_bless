package faang.school.godbless.triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
                    school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                    return school;
                }, executorService);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        executorService.shutdown();

        return futureSchool;
    }
}
