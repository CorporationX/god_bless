package bjs2_72969;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeasleyFamily {
    private static String[] chores = {"Wash the dishes", "Vacuum", "Do your homework"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(chores.length);

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("All tasks are completed");
    }
}
