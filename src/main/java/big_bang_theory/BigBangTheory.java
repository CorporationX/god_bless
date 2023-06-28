package big_bang_theory;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "modeling experiment"),
                new Task("Hovard", "instrument's development"),
                new Task("Radzshesh", "data analysis")
        );

        tasks.forEach(task -> {
            executorService.execute(task);
            log.info(task.name() + " task start");
        });
        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("All tasks are done");
    }
}
