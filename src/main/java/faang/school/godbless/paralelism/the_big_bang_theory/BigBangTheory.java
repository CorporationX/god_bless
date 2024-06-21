package faang.school.godbless.paralelism.the_big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private final static List<Task> TASKS = List.of(
            new Task("Sheldon Lee Cooper", "Theory preparation"),
            new Task("Leonard Hofstadter", "Simulation of experiment"),
            new Task("Howard Wolowitz", "Tool development"),
            new Task("Raj Koothrappali", "Data analysis"));
    private final static int POOLS_COUNT = 4;
    private final static ExecutorService executor = Executors.newFixedThreadPool(POOLS_COUNT);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runTasker(TASKS);
    }

    private static void runTasker(List<Task> tasks) throws ExecutionException, InterruptedException {
        if (tasks.isEmpty()) {
            throw new IllegalArgumentException("Tasks shouldn't be empty!");
        }
        for (Task task : tasks) {
            executor.submit(task).get();
        }
        System.out.println("All task done!");
        executor.shutdown();
    }
}
