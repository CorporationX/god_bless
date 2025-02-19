package school.faang.bigbang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BigBangTheory {
    private static final int THREAD_NUMBER = 4;
    private static final Logger LOGGER = Logger.getLogger(BigBangTheory.class.getName());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);
        LOGGER.setLevel(Level.INFO);

        List<Task> tasks = List.of(new Task("Sheldon", "Theory preparation"),
                new Task("Leonard", "Experiment modelling"),
                new Task("Howard", "Instruments development"),
                new Task("Radzhesh", "Data analysis"));

        for (Task task : tasks) {
            executor.submit(task);
        }

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        LOGGER.info("All tasks were done");
    }
}
