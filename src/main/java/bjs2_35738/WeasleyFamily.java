package bjs2_35738;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class WeasleyFamily {
    private List<Chore> chores;

    public void doChores() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Timeout reached. Forcing shutdown...");
            executorService.shutdownNow();
        }
    }
}
