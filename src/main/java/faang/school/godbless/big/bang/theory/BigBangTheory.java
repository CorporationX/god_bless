package faang.school.godbless.big.bang.theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "Prepare theory");
        Task leonardTask = new Task("Leonard", "Experiment modeling");
        Task howardTask = new Task("Howard", "Utils developing");
        Task rajeshTask = new Task("Rajesh", "Data analyzing");
        List<Task> tasks = List.of(sheldonTask, leonardTask, howardTask, rajeshTask);

        try {
            tasks.forEach(executorService::submit);
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(21, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("The team has just done its work");
    }
}
