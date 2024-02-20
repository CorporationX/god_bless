package faang.school.godbless.thebigbangtheory2852;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Simulation of experiment"),
                new Task("Hovard", "Tool development"),
                new Task("Rajesh", "Data analysis")));

        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All tasks are done! Guys are ready for whatever they should be ready for");
    }
}
