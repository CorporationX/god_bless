package BigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Howard", "development of tools"),
                new Task("Rajesh", "data analysis"));

        for (Task task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();

        System.out.println("Done!");
    }
}
