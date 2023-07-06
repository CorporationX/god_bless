package faang.school.godbless.task.bazzinga;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(
                new Task("Sheldon", "Preparing theory"),
                new Task("Leonard", "Modelling simulation"),
                new Task("Howard", "Developing toolkits"),
                new Task("Rajesh", "Data analysis")
        );

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All tasks were completed");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
