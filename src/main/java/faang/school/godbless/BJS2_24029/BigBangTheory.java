package faang.school.godbless.BJS2_24029;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasksList = List.of(new Task("Sheldon", "Preparation of theory"),
                new Task("Leonard", "Simulation of experiments"),
                new Task("Howard", "Development of tools"),
                new Task("Radjesh", "Data Analysis"));
        ExecutorService executor = Executors.newFixedThreadPool(4);
        tasksList.forEach(executor::execute);
        try {
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
