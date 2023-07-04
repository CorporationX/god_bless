package faang.school.godbless.big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Task> tasks = createTasks();

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks have completed!");
    }

    private static List<Task> createTasks() {
        return List.of(new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experiment simulation"),
                new Task("Howard", "Tools development"),
                new Task("Rajesh", "Data analysis"));
    }
}
