package faang.school.godbless.sprint3.bingBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BingBangTheory {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Sheldon", "task1");
        Task task2 = new Task("Leonard", "task2");
        Task task3 = new Task("Govard", "task3");
        Task task4 = new Task("Radzedzh", "task4");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);


        executorService.shutdown();

        try {

            boolean executorServiceIsDone = executorService.awaitTermination(30, TimeUnit.SECONDS);
            if (!executorServiceIsDone) {
                System.out.println("Can't close executor service");
                executorService.shutdownNow();
            } else {
                System.out.println("Thread executor tasks has done");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
