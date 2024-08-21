package faang.school.godbless.BJS2_24037;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int THREAD_AMOUNT = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        List<Task> tasks = Arrays.asList(
                new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experiment simulation"),
                new Task("Howard", "Development of tools"),
                new Task("Rajesh", "Data analysis")
        );
        tasks.forEach(executor::submit);
        executor.shutdown();

        Thread thread = new Thread(new Task("Oleg", "Learning"));
        thread.start();
        thread.interrupt();
    }
}
