package faang.school.godbless.task.bazzinga;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Sheldon", "Preparing theory"),
                new Task("Leonard", "Modelling simulation"),
                new Task("Howard", "Developing toolkits"),
                new Task("Rajesh", "Data analysis")
        ));

        for (Task task : tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
