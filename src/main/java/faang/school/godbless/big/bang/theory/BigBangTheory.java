package faang.school.godbless.big.bang.theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int TIME_FOR_WHOLE_PROJECT = 21;
    private static final int NUMBER_OF_WORKERS = 4;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_WORKERS);

        Task sheldonTask = new Task("Sheldon", "Prepare theory");
        Task leonardTask = new Task("Leonard", "Experiment modeling");
        Task howardTask = new Task("Howard", "Utils developing");
        Task rajeshTask = new Task("Rajesh", "Data analyzing");
        List<Task> tasks = List.of(sheldonTask, leonardTask, howardTask, rajeshTask);

        tasks.forEach(executorService::submit);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIME_FOR_WHOLE_PROJECT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException exception) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("The team has just done its work");
    }
}
