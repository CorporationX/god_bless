package faang.school.godbless.big_bang_teory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int TIME_TO_EXECUTE_TASKS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task taskForSheldon = new Task("Sheldon", "Preparing Theory");
        Task taskForLeonard = new Task("Leonard", "Modelling Experiment");
        Task taskForGoward = new Task("Goward", "Tool development");
        Task taskForRajesh = new Task("Radjesh", "Data analysis");

        executorService.execute(taskForSheldon);
        executorService.execute(taskForLeonard);
        executorService.execute(taskForGoward);
        executorService.execute(taskForRajesh);

        try {
            executorService.shutdown();
            boolean isFinishedOnTime = executorService.awaitTermination(TIME_TO_EXECUTE_TASKS, TimeUnit.SECONDS);
            if (isFinishedOnTime) {
                System.out.println("Tasks are finished on time");
            } else {
                System.out.println("Tasks were not finished on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not await termination " + e.getMessage());
        }
    }
}
