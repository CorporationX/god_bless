package ru.kraiush.BJS2_36655;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        for (String toDo : weasleyFamily.getChores()) {
            Chore chore = new Chore(toDo);
            executorService.submit(chore);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("The chores aren't competed for 10 seconds, force stopping...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
