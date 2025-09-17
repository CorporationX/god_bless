package bjs289597;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {
            "wash the dishes",
            "sweep the floor",
            "cook dinner",
            "do the laundry",
            "water the plants"};
    private static final int MAX_WAIT_MILLISECONDS = 12000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String task : CHORES) {
            executorService.submit(new Chore(task));
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(MAX_WAIT_MILLISECONDS, TimeUnit.MILLISECONDS)) {
                log.info("Not all tasks completed in {} minutes. Forcing termination...", MAX_WAIT_MILLISECONDS);
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            log.error("Waiting for threads finishing was interrupted..");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks were completed!");
    }
}
