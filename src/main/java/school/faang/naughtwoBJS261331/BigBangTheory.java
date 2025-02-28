package school.faang.naughtwoBJS261331;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int WAIT_TIME_MINUTES = 2;

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "experimental design"),
                new Task("Howard", "instrument development"),
                new Task("Rajesh", "data analysis")));

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Task task : tasks) {
            executor.submit(task);
        }

        log.debug("Tasks completed");
        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
