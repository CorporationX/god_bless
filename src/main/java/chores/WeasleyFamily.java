package chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {
                "Watering the plants...",
                "Vacuuming the floor...",
                "Cooking...",
                "Ironing the clothes...",
                "Making the bed...",
                "Cleaning the kitchen...",
                "Washing the dishes...",
                "Doing the laundry..."
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String choreTitle : chores) {
            Chore chore = new Chore(choreTitle);
            executorService.submit(chore);

        }

        executorService.shutdown();
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}