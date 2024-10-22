package school.faang.multithreading.theBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("some-task-name1", "some-task-description1");
        Task task2 = new Task("some-task-name2", "some-task-description2");
        Task task3 = new Task("some-task-name3", "some-task-description3");
        Task task4 = new Task("some-task-name4", "some-task-description4");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("The tasks were not completed within the specified time");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
