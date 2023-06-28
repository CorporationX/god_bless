package faang.school.godbless.Sprint_3.Multythreading.TheBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(new Task("Sheldon", "Theory"),
                new Task("Leonard", "experiment "),
                new Task("Howard", "Development"),
                new Task("Rajesh", "Analysis"));

        tasks.stream().forEach(task -> executor.execute(task));

        executor.shutdown();
    }
}
