package multithreading.thebigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Sheldon's_Task");
        Task task2 = new Task("Leonard", "Leonard's_Task");
        Task task3 = new Task("Govard", "Govard's_Task");
        Task task4 = new Task("Raj", "Raj's_Task");

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);

        executorService.shutdown();
    }
}
