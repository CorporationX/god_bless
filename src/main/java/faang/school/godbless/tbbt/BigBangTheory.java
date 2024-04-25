package faang.school.godbless.tbbt;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "theory preparation");
        Task task2 = new Task("Leonard", "experiment modelling");
        Task task3 = new Task("Howard", "development of tools");
        Task task4 = new Task("Rajesh", "data analysis");
        Set<Task> tasks = Set.of(task1, task2, task3, task4);
        pool.submit(() -> {
            for (Task task : tasks) {
                task.run();
            }
            System.out.println("All tasks completed");
        });
        pool.shutdown();
    }
}
