package school.faang.big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Task1", "Task1 description");
        Task task2 = new Task("Task2", "Task2 description");
        Task task3 = new Task("Task3", "Task3 description");
        Task task4 = new Task("Task4", "Task4 description");

        List<Task> tasks = List.of(task1, task2, task3, task4);

        for (Task task : tasks) {
            service.submit(task);
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
