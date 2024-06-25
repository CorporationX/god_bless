package faang.school.godbless.BJS212435;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Task sheldon = new Task("Sheldon", "Preparing theory");
        Task leonard = new Task("Leonard", "Modeling experiment");
        Task hovard = new Task("Hovard", "Developing tools");
        Task radzhesh = new Task("Radzhesh", "Data analyse");

        service.execute(sheldon);
        service.execute(leonard);
        service.execute(hovard);
        service.execute(radzhesh);

        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                List<Runnable> unfinishedTasks = service.shutdownNow();
                System.out.println("Tasks not finished ant stopped");
                unfinishedTasks.forEach(System.out::println);
            } else {
                System.out.println("All tasks finished successfully");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            service.shutdownNow();
            throw new RuntimeException("Thread was interrupted: " + e.getMessage());
        }

    }
}
