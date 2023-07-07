package Multithreading.bc3272_Triwizard_Tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<School> schoolResult = CompletableFuture.supplyAsync(() -> {
            System.out.println("The school " + school.getName() + " started the tournament...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.setPoints(task.getDifficulty() * task.getReward() + school.getYear());
            return school;
        }, executorService);

        executorService.shutdown();

        return schoolResult;
    }
}
