package faang.school.godbless.bjs225893;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {

        List<Task> tasks = List.of(
                new Task("Sheldon", "Theory Preparation"),
                new Task("Leonard", "Experiment modeling"),
                new Task("Howard", "Tool development"),
                new Task("Rajesh", "Data Analysis")
        );
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (var task : tasks) {
            executor.submit(task);
        }
        executor.shutdown();
    }
}