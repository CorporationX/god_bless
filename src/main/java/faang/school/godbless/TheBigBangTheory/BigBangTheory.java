package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Theory preparing");
        Task task2 = new Task("Leonard", "Experiment modeling");
        Task task3 = new Task("Goward", "Tools development");
        Task task4 = new Task("Rajesh", "Data analyzing");
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
            executorService.shutdownNow();
        }
        System.out.println("Tasks completed");
    }
}
