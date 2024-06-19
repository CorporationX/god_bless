package faang.school.godbless.multithreading.bigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Sheldon", "Preparation of theory");
        Task task2 = new Task("Leonard", "Experiment modeling");
        Task task3 = new Task("Howard", "Tool development");
        Task task4 = new Task("Rajesh", "Data analysis");

        threadPool.submit(task1);
        threadPool.submit(task2);
        threadPool.submit(task3);
        threadPool.submit(task4);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);

        System.out.println("All tasks are finished!");
    }
}
