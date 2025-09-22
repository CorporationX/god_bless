package school.faang.multithreading.parallelism.bjs2_89686;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();

        for (Chore chore : weasleyFamily.getChores()) {
            executorService.execute(chore);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}