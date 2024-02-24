package faang.school.godbless.bigbang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Task1", "description"),
                new Task("Task2", " description"),
                new Task("Task3", " description"),
                new Task("Task4", " description"),
                new Task("Task5", " description")
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);
        tasks.forEach(executor::submit);

        executor.shutdown();
        System.out.println("All task are done");
    }
}
