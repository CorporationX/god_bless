package faang.school.godbless.bigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {

    public static void main(String[] args) {
        List<Task> tasks = List.of(
            new Task("Sheldon", "Theory preparation"),
            new Task("Leonard", "Experiment simulation"),
            new Task("Howard", "Tool development"),
            new Task("Rajesh", "Data analysis")
        );

        ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
        tasks.forEach(executor::execute);
        executor.shutdown();
    }
}
