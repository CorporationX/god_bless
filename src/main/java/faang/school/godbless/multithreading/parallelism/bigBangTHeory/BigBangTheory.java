package faang.school.godbless.multithreading.parallelism.bigBangTHeory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> taskList = Arrays.asList(
                new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Simulation of experiment"),
                new Task("Howard", "Tool development"),
                new Task("Rajesh", "data analysis"));

        for (Task task : taskList) {
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
