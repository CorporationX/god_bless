package faang.school.godbless.Big_Bang_Theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            Task task1 = new Task("Groceries", "Buy some products");
            Task task2 = new Task("Gaming", "Spend 8 hour on Dark Souls");
            Task task3 = new Task("Health care", "Buy some medicine");
            Task task4 = new Task("Work", "Made o lot of work");
            executor.submit(task1);
            executor.submit(task2);
            executor.submit(task3);
            executor.submit(task4);
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
