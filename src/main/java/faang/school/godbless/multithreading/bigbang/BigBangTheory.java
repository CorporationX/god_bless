package faang.school.godbless.multithreading.bigbang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        Collections.addAll(tasks,
                new Task("Sheldon", "preparing theory"),
                new Task("Leonard", "experiment modeling"),
                new Task("Howard", "tools development"),
                new Task("Rajesh", "data analysis"));

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (Task task : tasks) {
            service.execute(task);
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();

                System.out.println("> Something went wrong");
            }else {
                System.out.println("> Everyone has finished their tasks");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
