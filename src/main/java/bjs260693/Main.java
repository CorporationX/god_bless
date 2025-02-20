package bjs260693;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final int TASKS_COMPLETED_DURATION_MS = 1000;

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        List<String> chores = weasleyFamily.getChores();
        chores.add("посмотреть лекцию");
        chores.add("решить основные задания");
        chores.add("начать решать дополнительные задания");
        List<Future<?>> choreFutures = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            Future<?> choreFuture = executorService.submit(new Chore(chore));
            choreFutures.add(choreFuture);
        }
        choreFutures.forEach(choreFuture -> {
            Object resultFuture;
            try {
                resultFuture = choreFuture.get();
            } catch (InterruptedException e) {
                LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                        Thread.currentThread().getName());
                throw new RuntimeException(e);
            } catch (ExecutionException ex) {
                LOGGER.error("Task in thread {} not completed due {}",
                        Thread.currentThread().getName(), ex.getCause().toString());
                throw new RuntimeException(ex);
            }

            LOGGER.info("Null has been received in confirmation {} ", choreFuture);
            LOGGER.info("returned of the result from {} from the thread {}",
                    resultFuture, Thread.currentThread().getName());
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TASKS_COMPLETED_DURATION_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Waiting for the completion of tasks in the ExecutorService is interrupted in the thread {}",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}
