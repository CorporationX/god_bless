package faang.school.godbless.Big_Bang_Theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Groceries", "Buy some products");
        Task task2 = new Task("Gaming", "Spend 8 hour on Dark Souls");
        Task task3 = new Task("Health care", "Buy some medicine");
        Task task4 = new Task("Work", "Made o lot of work");
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}
