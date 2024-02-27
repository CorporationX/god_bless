package faang.school.godbless.thebigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String... args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Sheldon", "task1");
        Task task2 = new Task("Leonard", "task2");
        Task task3 = new Task("Howard", "task3");
        Task task4 = new Task("Rajesh", "task4");

        List<Task> tasks = List.of(task1, task2, task3, task4);

        for (Task task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();
    }
}
