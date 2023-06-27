package faang.school.godbless.sprint4.theBigBangTheory.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "prepared for theory");
        Task task2 = new Task("Leonard", "Modelling experiment");
        Task task3 = new Task("Howard", "Tool development");
        Task task4 = new Task("Radgesh", "Analyst data");
        service.submit(task1);
        service.submit(task2);
        service.submit(task3);
        service.submit(task4);

        service.shutdown();

        if (service.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("All task is done");
        }
    }
}
