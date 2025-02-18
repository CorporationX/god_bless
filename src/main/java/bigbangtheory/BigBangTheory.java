package bigbangtheory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BigBangTheory {
    private static final Logger logger = Logger.getLogger(BigBangTheory.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> tasks = new HashMap<>();
        tasks.put("Sheldon", "Preparing the theory");
        tasks.put("Leonard", "Modeling the experiment");
        tasks.put("Howard", "Developing the tools");
        tasks.put("Rajesh", "Analyzing the data");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (var entry : tasks.entrySet()) {
            Task task = new Task(entry.getKey(), entry.getValue());
            executorService.submit(task);
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
        logger.info("All tasks has finished!");
    }
}
