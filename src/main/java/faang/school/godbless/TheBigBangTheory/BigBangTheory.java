package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "theory preparation");
        Task task2 = new Task("Leonard ", "experiment simulation");
        Task task3 = new Task("Howard ", "tool development");
        Task task4 = new Task("Rajesh ", "data analysis");
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(4L, TimeUnit.SECONDS)) {
                System.out.println("Timeout elapsed before termination.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Main thread was interrupted" + e);
        }
        System.out.println("All tasks have been completed");
    }

}
