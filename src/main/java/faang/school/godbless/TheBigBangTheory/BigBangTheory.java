package faang.school.godbless.TheBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Task1", "Complete homework"),
                new Task("Task2", "Buy groceries"),
                new Task("Task3", "Call mom"),
                new Task("Task4", "Go for a run")
        );

        for (Task task : tasks) {
            pool.execute(task);
        }

        pool.shutdown();

        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
