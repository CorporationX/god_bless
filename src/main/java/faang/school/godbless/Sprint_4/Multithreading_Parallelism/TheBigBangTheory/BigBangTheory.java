package faang.school.godbless.Sprint_4.Multithreading_Parallelism.TheBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(new Task("Sheldon", "Theory"),
                new Task("Leonard", "experiment "),
                new Task("Howard", "Development"),
                new Task("Rajesh", "Analysis"));

        tasks.stream().forEach(task -> executor.execute(task));

        executor.awaitTermination(7000, TimeUnit.MILLISECONDS);
        executor.shutdown();
        System.out.println("All tasks are done!");
    }
}
