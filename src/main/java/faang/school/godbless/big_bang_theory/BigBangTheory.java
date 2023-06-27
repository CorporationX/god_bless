package faang.school.godbless.big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "theory preparation");
        Task task2 = new Task("Leonard", "experiment simulation");
        Task task3 = new Task("Howard", "tool development");
        Task task4 = new Task("Rajesh", "data analysis");

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);
        executorService.shutdown();

        boolean isDone = executorService.awaitTermination(6, SECONDS);
        if(isDone == true) {
            System.out.println("All tasks completed!");
        }
    }
}
