package faang.school.godbless.Sprint4.Task_6_BigBang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Sheldon", "Preparing theory");
        Task task2 = new Task("Leonard", "Experiment simulation");
        Task task3 = new Task("Howard", "Tools development");
        Task task4 = new Task("Rajesh", "Data analysis");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);

        executorService.shutdown();
        executorService.awaitTermination(10, SECONDS);

        System.out.println("All tasks are completed!");
    }
}
