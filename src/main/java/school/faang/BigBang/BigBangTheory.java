package school.faang.BigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        List<Task> tasks = List.of(
                new Task("Task 1", "I"),
                new Task("Task 2", "II"),
                new Task("Task 3", "III"),
                new Task("Task 4", "IV")
        );
        ExecutorService service = Executors.newFixedThreadPool(4);

        tasks.forEach(service::execute);

        service.shutdown();

        if (!service.awaitTermination(20, TimeUnit.SECONDS)){
            System.out.println("Something went wrong");
            service.shutdownNow();
        }
    }
}
