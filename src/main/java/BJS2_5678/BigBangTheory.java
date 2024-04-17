package BJS2_5678;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Work");
        Task task2 = new Task("Leonard", "Study");
        Task task3 = new Task("Howard", "Wash face");
        Task task4 = new Task("Rajesh", "Cook");
        List<Task> tasks = List.of(task1, task2, task3, task4);

        for (Task task : tasks) {
            service.execute(task);
        }

        service.shutdown();
    }
}
