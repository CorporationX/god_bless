package chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {
            "Watering the plants...",
            "Vacuuming the floor...",
            "Cooking...",
            "Ironing the clothes...",
            "Making the bed...",
            "Cleaning the kitchen...",
            "Washing the dishes...",
            "Doing the laundry..."
    };
    private static final int SHUTDOWN_TIMEOUT_SECONDS = 60;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String choreTitle : CHORES) {
            Chore chore = new Chore(choreTitle);
            executorService.submit(chore);

        }

        executorService.shutdown();
        if (!executorService.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}