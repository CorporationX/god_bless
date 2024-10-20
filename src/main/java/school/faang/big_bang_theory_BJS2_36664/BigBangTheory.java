package school.faang.big_bang_theory_BJS2_36664;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        final int THREAD_COUNT = 4;
        final int AWAITING_TIME = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        Task task1 = new Task("Sheldon", "prepare theory");
        Task task2 = new Task("Leonard", "modeling of experiment");
        Task task3 = new Task("Howard", "development tools");
        Task task4 = new Task("Rajesh", "data analise");

        List<Task> tasks = new ArrayList<>(Arrays.asList(task1, task2, task3, task4));

        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Tasks did not complete in " + AWAITING_TIME + " minutes");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e.getMessage());
        }
    }
}
