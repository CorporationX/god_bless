package faang.school.godbless.big_bang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Sheldon", "preparation of the theory"),
                new Task("Leonard", "simulation of the experiment"),
                new Task("Howard", "tool development"),
                new Task("Rajesh", "data analysis")
        );
        tasks.forEach(service::submit);
        service.shutdown();
        if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
            service.shutdownNow();
        } else {
            System.out.println("All tasks done!");
        }
    }
}
