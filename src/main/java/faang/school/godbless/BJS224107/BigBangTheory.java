package faang.school.godbless.BJS224107;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Sheldon", "preparing the theory"),
                new Task("Leonard", "modeling the experiment"),
                new Task("Howard", "developing the tools"),
                new Task("Rajesh", "analyzing the data")
        );
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Task task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        while (!executor.isTerminated()) ;

        System.out.println("All tasks have been completed.");
    }
}
