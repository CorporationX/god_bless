package faang.school.godbless.multithreadingS4.bigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Howard", "development of tools"),
                new Task("Rajesh", "data analysis")
        );
        for (Task task : tasks) {
            service.submit(task);
        }

        service.shutdown();

        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("\nEveryone has completed their tasks");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

    }
}
