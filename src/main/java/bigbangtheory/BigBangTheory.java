package bigbangtheory;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD_POOL = Runtime.getRuntime().availableProcessors();
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> tasks = new HashMap<>();
        tasks.put("Sheldon", "Preparing the theory");
        tasks.put("Leonard", "Modeling the experiment");
        tasks.put("Howard", "Developing the tools");
        tasks.put("Rajesh", "Analyzing the data");

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        for (var entry : tasks.entrySet()) {
            Task task = new Task(entry.getKey(), entry.getValue());
            executorService.submit(task);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                log.warn("The thread pool was forcibly terminated!");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            log.error("Thread pool shutdown was interrupted!", e);
        }
    }
}
