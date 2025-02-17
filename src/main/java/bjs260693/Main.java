package bjs260693;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        String[] chores = weasleyFamily.getChores();
        Chore firstChore = new Chore(chores[0]);
        Chore secondChore = new Chore(chores[1]);
        Chore thirdChore = new Chore(chores[2]);

        Future<?> firstChoreFuture = executorService.submit(firstChore);
        Future<?> secondChoreFuture = executorService.submit(secondChore);
        Future<?> thirdChoreFuture = executorService.submit(thirdChore);

        LOGGER.info("Null has been received in confirmation of the return " +
                        "of the result from the Future<?> from the firstThread: {}",
                firstChoreFuture.get());
        LOGGER.info("Null has been received in confirmation of the return " +
                        "of the result from the Future<?> from the secondThread: {}",
                secondChoreFuture.get());
        LOGGER.info("Null has been received in confirmation of the return " +
                        "of the result from the Future<?> from the thirdThread: {}",
                thirdChoreFuture.get());

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
